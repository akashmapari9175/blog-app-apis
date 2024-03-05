package com.blog.apis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.apis.entitiy.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	

}
