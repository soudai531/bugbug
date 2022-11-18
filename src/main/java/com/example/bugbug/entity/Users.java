package com.example.bugbug.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Id
	private Integer user_id;
	private String name;
	private String icon;
	private String mail;
	private String pass;
	private Date reg_date_on;
}
