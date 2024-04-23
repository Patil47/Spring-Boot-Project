package com.jsp.StudentManagementSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StudentEntity {
	@Id
	private int id;
	private String name;
	private double grade;
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
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
