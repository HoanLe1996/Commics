package com.example.notetag.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.notetag.model.Tag;
import com.example.notetag.responsitory.TagReponsitory;

@RestController
public class TagController {

	@Autowired
	private TagReponsitory tagr;
	
	@RequestMapping(value = "/tags" , method =RequestMethod.GET)
	public List<Tag> getAlltag(){
		return tagr.findAll();
		
	}
	
	@PostMapping("/tags")
	public Tag createtag(@Valid @RequestBody Tag tag) {
		return tagr.save(tag);
	}
	
	@GetMapping("/tags/id_{id}")
	public Tag searchTagByid(@PathVariable Long id) {
		Optional<Tag> tag = tagr.findById(id);
		return tag.get();
	}
	
	@GetMapping("/tags/{title}")
	public Tag searchTagByid(@PathVariable String title) {
		Optional<Tag> tag = tagr.getTagByTitle(title);
		return tag.get();
	}
	
}
