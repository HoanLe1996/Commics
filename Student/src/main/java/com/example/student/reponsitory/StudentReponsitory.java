package com.example.student.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.model.Student;

@Repository
public interface StudentReponsitory extends JpaRepository<Student, Long> {
		public List<Student> getStudentByName(String name);
}
