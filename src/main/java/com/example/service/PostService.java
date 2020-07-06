package com.example.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.Entity.Post;
import com.example.Entity.UserLoginInformation;
import com.example.repo.PostRepo;
import com.example.repo.UserLoginRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepo postRepo;

	private final UserLoginRepo loginRepo;

	public Post savePost(Post post) {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		UserLoginInformation userLoginInformation = loginRepo.findByUserName(userName);
		post.setUserLoginInformation(userLoginInformation);
		return postRepo.save(post);
	}

	public List<Post> getAllPost() {
		return postRepo.findAll();
	}

	public Post getPost(Integer postid) {
		return postRepo.findById(postid).get();
	}

}
