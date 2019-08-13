package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.TeamDomain;
import com.example.reposiory.TeamRepository;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;
	
	@RequestMapping("")
	public String showList(Model model) {
		List<TeamDomain> teamList =teamRepository.findAll();
		model.addAttribute("teamList",teamList);
		return "teamNameList";
	}
	
	@RequestMapping("/load")
	public String showDetail(Integer id ,Model model) {
		TeamDomain team=teamRepository.load(id);
		model.addAttribute("team",team);
		return "teamDetail";
		
	}
	
}
