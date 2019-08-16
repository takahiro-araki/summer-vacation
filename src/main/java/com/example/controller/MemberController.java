package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.MemberDomain;
import com.example.reposiory.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class MemberController {
	@Autowired
	private MemberRepository memberRepository;
	
	
	@RequestMapping("")
	public String index() {
		return "exam05";
	}
	@RequestMapping("/load")
	public String load(String name,Model model) {
		List<MemberDomain> memberList=memberRepository.load(name);
		model.addAttribute("memberList",memberList);
		System.out.println(memberList);
		return "exam05-result";
		
		
	}

}
