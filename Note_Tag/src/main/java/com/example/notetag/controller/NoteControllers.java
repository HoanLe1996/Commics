package com.example.notetag.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.notetag.model.Note;
import com.example.notetag.responsitory.NoteReponsitory;

@RestController
public class NoteControllers {

	@Autowired
	private NoteReponsitory noter;
	
	@GetMapping("/notes")
	public List<Note> getAllNote() {
		return noter.findAll();
		
		
	}
	
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note) {
		return noter.save(note);
	}
	
	@GetMapping("/notes/id_{id}")
	public Note searchByid(@PathVariable Long id) {
		Optional<Note> note = noter.findById(id);
		if (note.isPresent()) {
			return note.get();
		} else {
			return new Note();
		}
	}
	
	@GetMapping("/notes/{title}")
	public Note searchNoteByid(@PathVariable String title) {
		Optional<Note> note = noter.getNoteByTitle(title);
		return note.get();
	}
	
	
}
