package com.example.bugbug.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bugbug.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	//メールでユーザー検索
	List<User> findByMail(String mail);

}
