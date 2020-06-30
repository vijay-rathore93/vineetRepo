package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer>{

}
