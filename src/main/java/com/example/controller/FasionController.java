package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.FasionDomain;
import com.example.reposiory.FasionRepository;

@Controller
@RequestMapping("/fasion")
public class FasionController {
	@Autowired
	private FasionRepository fasionRepository;

	/**
	 * 洋服検索画面を表示する.
	 * 
	 * @return 洋服検索画面
	 */
	/*
	 * @RequestMapping("") public String index() { return "fasionSearch" }
	 */
	/**
	 * 性別と色が合致した洋服情報を検索して、表示する.
	 * 
	 * @param 性別情報
	 * @param 色譲歩負
	 * @param リクエストスコープ
	 * @return 洋服検索画面
	 */
	@RequestMapping("/search")
	public String searchByColorAndGender(Integer gender, String color, Model model) {
		List<FasionDomain> fasionList = fasionRepository.load(gender, color);
		model.addAttribute("fasionList", fasionList);
		return "fasionSearch";
	}

}
