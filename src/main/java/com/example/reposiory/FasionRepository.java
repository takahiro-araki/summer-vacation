package com.example.reposiory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.FasionDomain;

/**
 *洋服情報レポジトリ 
 *
 * @author takahiro.araki
 *
 */
@Repository
public class FasionRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static RowMapper<FasionDomain> FASION_ROW_MAPPER=(rs,i)->{
		FasionDomain fasion=new FasionDomain();
		fasion.setId(rs.getInt("id"));
		fasion.setSize(rs.getString("size"));
		fasion.setCategory(rs.getString("category"));
		fasion.setColor(rs.getString("color"));
		fasion.setGenre(rs.getString("genre"));
		fasion.setGender(rs.getInt("gender"));
		fasion.setPrice(rs.getInt("price"));
		return fasion;
	};
	
	/**
	 * 性別と色で照合した洋服情報を検索する.
	 * 
	 * @param 性別情報
	 * @param 色情報
	 * @return　洋服情報の入ったリスト
	 */
	public List<FasionDomain> load(Integer gender,String color){
		String loadSql="SELECT id,category,genre,gender,color,price,size FROM clothes WHERE gender=:gender AND color=:color";
		SqlParameterSource param=new MapSqlParameterSource().addValue("gender",gender).addValue("color",color);
		List<FasionDomain> fasionList=template.query(loadSql, param, FASION_ROW_MAPPER);
		return fasionList;
	}

}
