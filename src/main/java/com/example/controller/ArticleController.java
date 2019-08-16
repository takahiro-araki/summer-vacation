package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.reposiory.AricleRepository;
import com.example.reposiory.CommentRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private AricleRepository articleRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	
	@RequestMapping("")
	public  String index(Model model) {
		List<Article>articleList=articleRepository.findAll();
		model.addAttribute("articleList",articleList);
		System.out.println(articleList);
		return "article";
	}
	
	@RequestMapping("/insert")
	public String insert(String name,String content) {
		articleRepository.insert(name, content);
		return "redirect:/article";
		
		
	}
	@RequestMapping("/delete")
	public String delete(Integer id) {
		commentRepository.delete(id);
		articleRepository.delete(id);
		return "redirect:/article";
	}

}
