package com.example.bugbug.service;

import com.example.bugbug.config.AppConfig;
import com.example.bugbug.entity.Users;
import com.example.bugbug.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyAccountServiceImpl implements MyAccountService{
    @Autowired
    private HttpSession session;

    // 画像の保存場所を保持しているBean
    private final AppConfig appConfig;
    // ユーザーテーブルのリポジトリ
    private final UserRepository userRepository;

    /**
     * ユーザーアイコンを変更
     * @param file 保存する画像ファイル
     * @param userId アイコンを変更するユーザーID
     * @return 画像ファイル名
     */
    public String saveUserIcon(MultipartFile file, int userId){
        // IDのフォーマット(0埋め)
        String userIdFormat = String.format("%010d", userId);
        // ファイル名の作成
        String fileName = "user-icon_" + userIdFormat +".jpg";
        // URIの作成
        File dest = new File(appConfig.getDirMap().get("user-icon"),fileName);
        try {
            //ファイルをパス(dest)に転送する
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        // DBにファイル名を保存する
        userRepository.updateIcon(fileName,userId);
        return fileName;
    }

    /**
     * 自分のアイコン画像ファイル名を取得する
     */
    public String getMyIcon(){
        // セッションからユーザーIDの取得
        int userId = Integer.parseInt(session.getAttribute("user_id").toString());
        // ユーザー情報を取得
        Optional<Users> user = userRepository.findById(userId);
        // ユーザーアイコンのファイル名を返す
        return user.get().getIcon();
    }
}
