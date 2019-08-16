package com.example.domain;

import java.util.List;

/**
 * 記事ドメイン
 * 
 * @author takahiro.araki
 *
 */
public class Article {
	/**id*/
	private Integer id;
	/**名前*/
	private String name;
	/**内容*/
	private String content;
	/**コメントリスト*/
	private List<Comment> commentList;
	
	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", content=" + content + ", commentList=" + commentList + "]";
	}

	
}
