package com.example.bugbug.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bugbug.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer>{
	//メールでユーザー検索
	List<Users> findByMail(String mail);
}
