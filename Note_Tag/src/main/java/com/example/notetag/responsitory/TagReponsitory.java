package com.example.notetag.responsitory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.notetag.model.Tag;

@Repository
public interface TagReponsitory extends JpaRepository<Tag, Long> {
	
	@Query(value ="select tag from Tag tag where title = ?1" ,nativeQuery = false)
	Optional<Tag> getTagByTitle(String title);
}
