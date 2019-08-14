package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;

/**
 * ユーザー情報コントローラー
 * 
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/ex04")
public class Exam04Controller {
	
	/**
	 * ユーザーフォームをリクエストスコープへ格納.
	 * @return　ユーザーフォーム
	 */
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	} 
	
	/**
	 * ユーザー情報入力画面を表示.
	 * @return　入力画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex04";
	}
	
	
	/**
	 * 入力値を、結果表示画面で表示
	 * @param userForm　入力値の入ったユーザーフォームオブジェクト
	 * @param model　リクエストスコープ
	 * @return　結果表示画面
	 */
	@RequestMapping("/extend")
	public String extend(@Validated UserForm userForm,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ex04";
		}
		User user =new User();
		Integer intAge=Integer.parseInt(userForm.getAge());
		user.setAge(intAge);
		user.setName(userForm.getName());
		user.setComment(userForm.getComment());
		model.addAttribute("user",user);
		return "ex04-result";
		
		
	}
	
	

}
