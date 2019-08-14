package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 計算機コントローラー.
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/ex3")
public class Ex3Controller {
	
	@Autowired
	private ServletContext application;
	
	/**
	 * 価格表示画面の表示.
	 * @return 価格表示画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex03";
	}
	
	
	/**
	 * 入力された値から、合計の「税込み価格」と「税抜き価格」を計算して、合計金額表示画面に表示
	 * @param 商品１の金額
	 * @param 商品2の金額
	 * @param 商品３の金額
	 * @return　合計金額表示画面
	 */
	@RequestMapping("/calc")
	public String calc(Integer num1,Integer num2,Integer num3) {
		Double answer =(num1+num2+num3)*0.92;
		Double answer2 =(num1+num2+num3)*1.08;
		application.setAttribute("answer", answer);
		application.setAttribute("answer2", answer2);
		return "ex3-result";
		
		
		
	}

}
