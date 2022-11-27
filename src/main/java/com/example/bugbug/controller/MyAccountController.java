package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import com.example.bugbug.config.AppConfig;
import com.example.bugbug.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// マイアカウント関係のコントローラー
@RequiredArgsConstructor
@Controller
public class MyAccountController {

    @Autowired
    private HttpSession session;
    @Autowired //@Beanなどをつけて事前設定されたインスタンスを使用するには@Autowiredが必要（AppConfigクラスが使えるようになる）
    private AppConfig appConfig;
    private final AuthService authService;

    /**
     * マイページ表示
     */
    @RequestMapping("mypage")
    public String viewMypage(Model model) {
        //  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        model.addAttribute("userId", session.getAttribute("user_id"));
        return "mypage";
    }

    @RequestMapping("users/{userId}/logout")
    public String logout(SessionStatus sessionStatus) {
        // sessionに登録さてている情報を削除
        session.removeAttribute("user_id");
        session.removeAttribute("user_name");
        // sessionの破棄
        session.invalidate();
        // sessionの完了
        sessionStatus.setComplete();
        return "redirect:/index";
    }

    /**
     * ユーザーアイコンの登録（変更も兼ねる）
     */
    @PostMapping("/users/{userId}/user-icon/update")
    public String updateUserIcon(@PathVariable int userId, @RequestParam MultipartFile file,  Model model) {
        // ログイン済みか確認
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        // ファイルがないとき
        if(file.isEmpty()) {
            model.addAttribute("error", "ファイルを指定してください");
            return "mypage";
        }
        // ファイル名を作成
        String userIdFormat = String.format("%010d", userId);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTime = sdf.format(cal.getTime());
        String fileName = "user-icon_" + userIdFormat + "_" + dateTime + ".jpg";
        File dest = new File(appConfig.getImageDir(),fileName);
        try {
            //ファイルをパス(dest)に転送する
            file.transferTo(dest); //表示される修正候補の「try/catchで囲む」を選択
        } catch (IllegalStateException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        // return "redirect:/index";
        return "redirect:/mypage";
    }

}
