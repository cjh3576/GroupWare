package com.web.group.member;

import javax.validation.constraints.NotBlank;

import com.web.group.memberImage.MemberImageVO;


public class MemberVO {
	private int num;
	@NotBlank
	private String id;
	@NotBlank
	private String pw;
	@NotBlank
	private String name;
	@NotBlank
	private String regnum;
	@NotBlank
	private String phone;
	@NotBlank
	private String email;
	@NotBlank
	private String gender;
	private int age;
	@NotBlank
	private String team;
	@NotBlank
	private String rank;
	
	private MemberImageVO memberImageVO;
	
	public MemberVO() {}
	
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegnum() {
		return regnum;
	}
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

	public MemberImageVO getMemberImageVO() {
		return memberImageVO;
	}

	public void setMemberImageVO(MemberImageVO memberImageVO) {
		this.memberImageVO = memberImageVO;
	}
}
