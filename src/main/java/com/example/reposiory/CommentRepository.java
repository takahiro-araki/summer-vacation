package com.example.reposiory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

@Repository
public class CommentRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public final static RowMapper<Comment> COMMENT_ROW_MAPPER=(rs,i)->{
		Comment comment=new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("article_id"));
		return comment;
	};
	
	public void insert(Comment comment) {
		String insertSql="INSERT INTO comments (name,content,article_id) VALUES (:name,:content,:articleId) ";
		SqlParameterSource param=new BeanPropertySqlParameterSource(comment);
		template.update(insertSql, param);
	}
	
	public void delete(Integer id) {
		String deleteSql="DELETE FROM comments WHERE article_id=:articleId";
		SqlParameterSource param=new MapSqlParameterSource().addValue("articleId",id);
		template.update(deleteSql, param);
		
	}
	
	
	
}