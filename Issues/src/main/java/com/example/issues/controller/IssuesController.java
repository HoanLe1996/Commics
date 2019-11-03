package com.example.issues.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Issues;
import com.example.reponsitory.IssuesReponsitory;

@Controller
@RequestMapping("/issues")
public class IssuesController {

//	@Autowired
//	private IssuesReponsitory issues_re;

	@GetMapping("/issuereport")
	public String form_issues(Model model) {
		model.addAttribute("issuereport", new Issues());
		return "issuereport_form";
	}

	@PostMapping("/issuereport")
	public String submitReport(Model model, @Valid @RequestBody Issues issues) {
		model.addAttribute("issuereport", new Issues());
		model.addAttribute("submitted", true);
		return "redirect:/issues";
	}

	@GetMapping("/issues")
	public String getAllIssue(Model model) {
	//	List<Issues> all_issues = issues_re.findAll();
	//	model.addAttribute("list_issues", all_issues);
		return "issuereport_list";
	}

}
