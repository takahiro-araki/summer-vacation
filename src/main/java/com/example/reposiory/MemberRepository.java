package com.example.reposiory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.MemberDomain;

/**
 *メンバー情報レポジトリ.
 *
 * @author takahiro.araki
 *
 */
@Repository
public class MemberRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static RowMapper<MemberDomain> MEMBER_ROW_MAPPER=(rs,i)->{
		MemberDomain member=new MemberDomain();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		return member;
		
	};
	
	
	/**
	 * 名前のあいまい検索を行う.
	 * @param 名前
	 * @return　メンバー情報が入ったリスト
	 */
	public List<MemberDomain> load(String name){
		String loadSql="SELECT id,name,age,dep_id FROM members WHERE name LIKE '%':name'%' ";
		SqlParameterSource param=new  MapSqlParameterSource().addValue("name", name);
		List<MemberDomain> memberList=template.query(loadSql, param, MEMBER_ROW_MAPPER);
		return memberList;
		
	
}
}
