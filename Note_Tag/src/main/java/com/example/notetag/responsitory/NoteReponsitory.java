package com.example.notetag.responsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.notetag.model.Note;

@Repository
public interface NoteReponsitory extends JpaRepository<Note, Long> {
	@Query(value ="select note from Note note where title = ?1" ,nativeQuery = false)
	Optional<Note> getNoteByTitle(String title);
}
