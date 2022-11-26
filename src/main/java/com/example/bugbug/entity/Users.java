package com.example.bugbug.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class Users {
	@Id
	@Column("user_id")
	private Integer userId;
	private String name;
	private String icon;
	private String mail;
	private String password;
	@Column("reg_date_on")
	private Date regDateOn;
}
