package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/name")
public class Exam01Controller {
	
	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	@RequestMapping("/input")
	public String result(String name, Model model) {
		model.addAttribute("name",name);
		return "exam01-result";
	}
	
	


}
