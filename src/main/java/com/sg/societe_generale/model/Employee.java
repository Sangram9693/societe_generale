package com.sg.societe_generale.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	@NotNull
	@Size(min=3, message="First name should have atleast 3 characters")
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	@Size(min=3, message="Last name should have atleast 3 characters")
	private String lastName;
	
	@Column(name="gender")
	@NotNull(message="Gender is required")
	private String gender;
	
	@Column(name="dob")
	@NotNull(message="Date of birth is required")
	private Date dob;
	
	@Column(name="department")
	@NotNull
	@Size(min=3, message="Department should have atleast 3 characters")
	private String department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id,
			@NotNull @Size(min = 3, message = "First name should have atleast 3 characters") String firstName,
			@NotNull @Size(min = 3, message = "Last name should have atleast 3 characters") String lastName,
			@NotNull(message = "Gender is required") String gender,
			@NotNull(message = "Date of birth is required") Date dob,
			@NotNull @Size(min = 3, message = "Department should have atleast 3 characters") String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public Date getDob() {
		return dob;
	}

	public String getDepartment() {
		return department;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", dob=" + dob + ", department=" + department + "]";
	}
}
