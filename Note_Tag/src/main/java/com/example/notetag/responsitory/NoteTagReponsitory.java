package com.example.notetag.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notetag.model.Note_Tag;

@Repository
public interface NoteTagReponsitory extends JpaRepository<Note_Tag, Long> {

}
