package com.blog.apis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.apis.entitiy.Category;
import com.blog.apis.entitiy.Post;
import com.blog.apis.entitiy.User;
import com.blog.apis.payloads.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	Post save(Post post);
}
