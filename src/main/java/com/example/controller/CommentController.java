package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Comment;
import com.example.reposiory.CommentRepository;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@RequestMapping("/insert")
	public String insert(String name ,String content ,Integer articleId,Model model) {
		Comment comment=new Comment();
		comment.setName(name);
		comment.setContent(content);
		comment.setArticleId(articleId);
		commentRepository.insert(comment);
		return "forward:/article";
	}
	
	
	

}
