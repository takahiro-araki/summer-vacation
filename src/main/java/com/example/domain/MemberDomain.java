package com.example.domain;

/**
 * メンバー情報ドメイン.
 * 
 * @author takahiro.araki
 *
 */
public class MemberDomain {
	/**ID*/
	private Integer id;
	/**名前*/
	private String name;
	/**年齢*/
	private Integer age;
	/**部署ＩＤ*/
	private Integer depId;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getDepId() {
		return depId;
	}
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	@Override
	public String toString() {
		return "MemberDomain [id=" + id + ", name=" + name + ", age=" + age + ", depId=" + depId + "]";
	}

}
