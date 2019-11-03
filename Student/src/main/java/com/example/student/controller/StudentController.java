package com.example.student.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.student.model.Student;
import com.example.student.reponsitory.StudentReponsitory;

@Controller
public class StudentController {

	@Autowired
	private StudentReponsitory str ;
	
	// Hien trang chu
	@GetMapping("/")
	public String getIndex() {
		return "redirect:/students";
	}
	
	//hien thi danh sach sinh vien
	@GetMapping("/students")
	public String GetAll(Model model) {
		model.addAttribute("students", str.findAll());
		return "list-student";
	}
	// Hien trang them sv
	@GetMapping("/students/signup")
	public String addStudent(Student student) {
		return "add-student";
	}
	// Tao Sinh Vien
	@PostMapping("/students/add")
	public String createSv(@Valid Student student, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "add-student";
		}
		str.save(student);
		return "redirect:/students";	
	}
	//update sinh vien 
	@GetMapping("/students/edit/{id}")
	public String update(@PathVariable("id") Long id, BindingResult result, Model model) {
		
		model.addAttribute("student", str.findById(id));
		return "edit-student";
		
	}
	@PutMapping("/students/update/{id}")
	public String update(@PathVariable("id") Long id,@Valid Student student, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/students/edit/{id}";
		}
		str.save(student);
		return "redirect:/students";
	}
	@DeleteMapping("/students/delete/{id}")
	public String deleteS(@PathVariable("id") Long id , @Valid Student student) {
		Optional<Student> std = str.findById(id);
		if(!std.isPresent()) {
			
		}
		str.delete(std.get());
		return "redirect:/students";
	}
	
}
