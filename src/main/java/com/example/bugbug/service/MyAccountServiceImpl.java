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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MyAccountServiceImpl implements MyAccountService{
    @Autowired
    private HttpSession session;
    private final AppConfig appConfig;
    private final UserRepository userRepository;

    public String saveUserIcon(MultipartFile file, int userId){
        String userIdFormat = String.format("%010d", userId);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateTime = sdf.format(cal.getTime());
        String fileName = "user-icon_" + userIdFormat + "_" + dateTime + ".jpg";
        File dest = new File(appConfig.getImageDir(),fileName);
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
        String userIdStr = Integer.valueOf(userId).toString();
        System.out.println(userId);
        System.out.println(fileName);
        userRepository.updateIcon(fileName,userId);
        return fileName;
    }

    public String getIcon(int userId){
        Optional<Users> user = userRepository.findById(userId);
        return user.get().getIcon();
    }
}
