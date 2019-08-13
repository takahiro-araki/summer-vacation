package com.example.reposiory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.HotelDomain;

/**
 * ホテル情報レポジトリ
 * 
 * @author takahiro.araki
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static RowMapper<HotelDomain> HOTEL_ROW_MAPPER=(rs,i)->{
		HotelDomain hotel=new HotelDomain();
		hotel.setId(rs.getInt("id"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	/**
	 * 引数に指定した価格以下のホテル情報を検索する.
	 * @param price 価格情報
	 * @return ホテル情報の入ったリスト
	 */
	public List<HotelDomain> load(Integer price){
		String loadSql="SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM hotels WHERE price<=:price ";
		SqlParameterSource param=new MapSqlParameterSource().addValue("price",price);
		List<HotelDomain> hotelList=template.query(loadSql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	

}
