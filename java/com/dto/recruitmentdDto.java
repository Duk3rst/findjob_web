package com.dto;

public class recruitmentdDto {
	
	private String title;
	private String description;
	private String experience;
	private int quantity;
	private String address;
	private String deadline;
	private String salary;
	private int category_id;

	public recruitmentdDto(String title, String description, String experience, int quantity, String address,
			String deadline, String salary, int category_id) {
		super();
		this.title = title;
		this.description = description;
		this.experience = experience;
		this.quantity = quantity;
		this.address = address;
		this.deadline = deadline;
		this.salary = salary;
		this.category_id = category_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return description;
	}

	public void setDescript(String descript) {
		this.description = descript;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
}
