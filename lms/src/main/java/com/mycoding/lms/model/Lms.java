package com.mycoding.lms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Lms implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<String> getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(List<String> leaveType) {
		this.leaveType = leaveType;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getNumberofDays() {
		return numberofDays;
	}

	public void setNumberofDays(int numberofDays) {
		this.numberofDays = numberofDays;
	}

	public List<String> getManager() {
		return manager;
	}

	public void setManager(List<String> manager) {
		this.manager = manager;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getCcTo() {
		return ccTo;
	}

	public void setCcTo(List<String> ccTo) {
		this.ccTo = ccTo;
	}

	@NotNull 
	private int empId;
	
	@NotEmpty 
	private String empName;
	 
	private List<String> leaveType = new ArrayList<String>();
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past @NotNull
	private Date fromDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past @NotNull
	private Date toDate;
	
	@NotNull 
	private int numberofDays;
	
	private List<String> manager = new ArrayList<String>();

	@NotEmpty 
	private String reason;
	
	@NotNull 
	private int contact;
	
	@Email @NotEmpty
	private String email;
	
	private List<String> ccTo = new ArrayList<String>();
}
