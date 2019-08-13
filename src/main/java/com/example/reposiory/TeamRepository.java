package com.example.reposiory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.TeamDomain;

/**
 *チーム情報レポジトリ
 * 
 * @author takahiro.araki
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public static  final RowMapper<TeamDomain>  TEAM_ROW_MAPPER=(rs,i)->{
		TeamDomain team= new TeamDomain();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setHeadquarter(rs.getString("headquarters"));
		team.setTeamName(rs.getString("team_name"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};
	
	/**
	 * チーム名の全件検索をする（発足日の昇順）.
	 * @return　チーム名が入ったリスト
	 */
	public List<TeamDomain> findAll(){
		String findAllSql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY inauguration";
		List<TeamDomain> teamList=template.query(findAllSql, TEAM_ROW_MAPPER);
		return teamList;
	}
	
	/**
	 * チーム情報を主キー検索する.
	 * @param 主キーid
	 * @return チーム情報
	 */
	public TeamDomain load(Integer id) {
		String loadSql="SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id=:id";
		SqlParameterSource param=new MapSqlParameterSource().addValue("id",id);
		TeamDomain team=template.queryForObject(loadSql, param, TEAM_ROW_MAPPER);
		return team;
	}
}
