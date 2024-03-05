package com.blog.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.payloads.PostDto;
import com.blog.apis.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	//create 
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
		 PostDto createPost = postService.createPost(postDto, userId, categoryId);
		 return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	//return post
	@GetMapping("/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId)
	{
		List<PostDto> listDto = this.postService.getPostByUserId(userId);
		return new  ResponseEntity<List<PostDto>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer categoryId)
	{
		List<PostDto> listDto = this.postService.getPostByCategoryId(categoryId);
		return new  ResponseEntity<List<PostDto>>(listDto,HttpStatus.OK);
	}
	
	@GetMapping("/getpost/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
		PostDto post = this.postService.getPost(postId);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	}
	
	//get all post 
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPost(
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "3",required = false) Integer pageSize
			){
		
		List<PostDto> allPost = this.postService.getAllPost(pageNumber,pageSize);
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	}
	
	//delete post by id
	@DeleteMapping("/delete/{postId}")
	public String deletePost(@PathVariable Integer postId)
	{
		this.postService.deletePost(postId);
		
		return postId+" : this post deleted successfully";
	}
}
