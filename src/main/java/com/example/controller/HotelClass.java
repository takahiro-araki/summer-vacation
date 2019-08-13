package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.HotelDomain;
import com.example.reposiory.HotelRepository;

/**
 * ホテル情報コントローラー
 * @author takahiro.araki
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelClass {
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報検索画面を表示する.
	 * @return　ホテル情報検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "hotelSearch";
	}
	
	/**
	 * 検索画面から引き取った価格情報を基に、価格以下のホテル情報を検索して表示する.
	 * @param price 検索画面から受け取った価格情報
	 * @param model　リクエストスコープ
	 * @return　ホテル情報検索画面
	 */
	@RequestMapping("/search")
	public String searchByLessThanPrice(Integer price ,Model model ) {
		List<HotelDomain> hotelList=hotelRepository.load(price);
		model.addAttribute("hotelList",hotelList);
		return "hotelSearch";
	}
	
	

}
