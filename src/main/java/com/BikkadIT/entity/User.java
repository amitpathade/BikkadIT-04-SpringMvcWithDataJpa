package com.BikkadIT.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private  int uid;
	
	private String name;
	
	private String uname;
	
	private String passward;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("name setter called");
		this.name = name;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		System.out.println("uname setter called");
		this.uname = uname;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		System.out.println("passward setter called");
		this.passward = passward;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", uname=" + uname + ", passward=" + passward + "]";
	}
	
	

}
