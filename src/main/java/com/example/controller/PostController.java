package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Post;
import com.example.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@PostMapping("/posts")
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}

	@GetMapping("/posts")
	public List<Post> getAllPost() {
		return postService.getAllPost();
	}

	@GetMapping("/posts/{id}")
	public Post savePost(@PathVariable Integer postid) {
		return postService.getPost(postid);
	}

}
