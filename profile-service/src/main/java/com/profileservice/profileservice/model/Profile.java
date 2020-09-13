package com.profileservice.profileservice.model;

public class Profile {

	private int id;
	private String name;

	public Profile() {
		super();
	}

	public Profile(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + "]";
	}

}
