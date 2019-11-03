package com.example.exception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manytomany.model.Post;
import com.example.manytomany.repository.PostRepository;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postctl;
	
	@GetMapping("/posts")
	public List<Post> listPost() {
		
		return postctl.findAll();
	}

}
