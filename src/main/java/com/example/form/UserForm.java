package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * ユーザーフォーム.
 * 
 * @author takahiro.araki
 *
 */
public class UserForm {
	/**名前*/
	@NotBlank(message="名前は必須です")
	private String name;
	/**年齢*/
	
	private String age;
	/**コメント*/
	@NotBlank(message="コメントを書いてください")
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

}
