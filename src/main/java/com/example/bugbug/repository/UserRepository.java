package com.example.bugbug.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bugbug.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	// メールでユーザー検索
	List<Users> findByMail(String mail);

	// ユーザーアイコンの更新
	@Modifying
	@Query("UPDATE users SET icon = :fileName WHERE user_id = :userId")
	void updateIcon(@Param("fileName") String fileName, @Param("userId") int userId);
}
