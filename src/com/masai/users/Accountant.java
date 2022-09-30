package com.masai.users;

public class Accountant {

	private int id;
	private String first_name;
	private String last_name;
	private String user_name;
	private String password;
	public Accountant(int id, String first_name, String last_name, String user_name, String password) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_name = user_name;
		this.password = password;
	}
	public Accountant() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Accountant [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", user_name="
				+ user_name + ", password=" + password + "]";
	}
	
	
}
