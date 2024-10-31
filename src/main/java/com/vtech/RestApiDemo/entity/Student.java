package com.vtech.RestApiDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_roll_seq_gen")
    @SequenceGenerator(name = "student_roll_seq_gen", sequenceName = "student_roll_seq", allocationSize = 1)
	@Column(name = "student_roll")
	private int rollNo;
	@Column(name = "student_name")
	private String name;
	@Column(name = "student_branch")
	private String branch;
	@Column(name = "student_percentage")
	private String percentage; 

	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public String getBranch() {
		return branch;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public Student(int rollNo, String name, String branch, String percentage) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
