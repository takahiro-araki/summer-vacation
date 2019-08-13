package com.example;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.CalcForm;

@Controller
@RequestMapping("/calc")
public class Exam02Controller {
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	
	
	@Autowired
	private  HttpSession  httpsession;
	
	@ModelAttribute
	public CalcForm setUpForm() {
		CalcForm calcForm =new CalcForm();
		return calcForm;
	} 
	
	
	@RequestMapping("/input")
	public String input(Integer num1,Integer num2) {
		
		
		httpsession.setAttribute("num1",num1);
		httpsession.setAttribute("num2",num2);
		int answer =num1+num2;
		httpsession.setAttribute("answer",answer);
		
		return "exam02-result";
		
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:input";
	}
	
	

}
