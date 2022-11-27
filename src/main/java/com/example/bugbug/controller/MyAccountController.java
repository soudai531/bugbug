package com.example.bugbug.controller;

import javax.servlet.http.HttpSession;

import com.example.bugbug.service.AuthService;
import com.example.bugbug.service.MyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// マイアカウント関係のコントローラー
@RequiredArgsConstructor
@Controller
public class MyAccountController {

    @Autowired
    private HttpSession session;
    private final AuthService authService;
    private final MyAccountService myAccountService;

    /**
     * マイページ表示
     */
    @RequestMapping("mypage")
    public String viewMypage(Model model) {
        //  ログイン状態判定
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        // アイコンテスト表示
        model.addAttribute("userIcon", myAccountService.getMyIcon());
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
    public String updateUserIcon(@PathVariable int userId, @RequestParam MultipartFile file, Model model , RedirectAttributes redirectAttributes) {
        // ログイン済みか確認
        if (!authService.isLogin()) {
            return "redirect:/login/form";
        }
        // ファイルがないとき
        if(file.isEmpty()) {
            model.addAttribute("error", "ファイルを指定してください");
            return "mypage";
        }
        //画像を保存
        String imageFileName = myAccountService.saveUserIcon(file,userId);
        return "redirect:/mypage";
    }

}
