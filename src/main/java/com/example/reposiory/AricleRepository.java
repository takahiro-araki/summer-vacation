package com.example.reposiory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;
import com.example.domain.Comment;

@Repository
public class AricleRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static ResultSetExtractor<List<Article>> ARTICLE_RS_EXTRACTOR = (rs) ->{
		Integer preId=-1;
		List <Comment> commentList=null;
		List <Article> articleList=new ArrayList<>();
		while(rs.next()) {if(preId!=rs.getInt("a_id")) {
			Article article=new Article(); 
			article.setId(rs.getInt("a_id"));
			article.setName(rs.getString("a_name"));
			article.setContent(rs.getString("a_content"));
			commentList=new ArrayList<>();
			article.setCommentList(commentList);
			articleList.add(article);
		}preId=rs.getInt("a_id");
		if(rs.getInt("c_articleId") !=0) {
			Comment comment =new Comment();
			comment.setId(rs.getInt("c_id"));
			comment.setName(rs.getString("c_name"));
			comment .setContent(rs.getString("c_content"));
			comment.setArticleId(rs.getInt("c_articleId"));
			commentList.add(comment);
		}}return articleList;
	};
	
	public List<Article> findAll(){
		String findAllSql="SELECT articles.id as a_id, articles.name as a_name, articles.content as a_content, comments.id as c_id,comments.name as c_name,comments.content as c_content,comments.article_id as c_articleId FROM articles LEFT OUTER JOIN comments ON articles.id=comments.article_id ORDER BY articles.id desc  ";
		List<Article> articleList=template.query(findAllSql, ARTICLE_RS_EXTRACTOR);
		return articleList;
	}
	
	public void insert(String name,String content) {
		String insertSql="INSERT INTO articles (name,content) VALUES(:name,:content)";
		SqlParameterSource param=new MapSqlParameterSource().addValue("name",name).addValue("content",content);
		template.update(insertSql, param);	
	}
	
	public void delete(Integer id) {
		String deleteSql="DELETE FROM articles WHERE id=:id";
		SqlParameterSource param=new MapSqlParameterSource().addValue("id",id);
		template.update(deleteSql, param);
		
	}
	
}