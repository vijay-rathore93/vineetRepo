package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repo.PostRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostRepo postRepo;

}
