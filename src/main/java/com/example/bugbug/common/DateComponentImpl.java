package com.example.bugbug.common;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class DateComponentImpl implements DateComponent {

	// 日付の取得
    @Override
    public Date getDate() {
        // 日付の取得
        Date date = new Date(new java.util.Date().getTime());
        return date;
    }
}
