package com.example.domain;

public class TeamDomain {
	
	private Integer id;
	private String leagueName;
	private String teamName;
	private String headquarter;
	private String inauguration;
	private String history;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getHeadquarter() {
		return headquarter;
	}
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	public String getInauguration() {
		return inauguration;
	}
	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "TeamDomain [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headquarter="
				+ headquarter + ", inauguration=" + inauguration + ", history=" + history + "]";
	}
	
	
	

}
