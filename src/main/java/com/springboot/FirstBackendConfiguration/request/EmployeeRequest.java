package com.springboot.FirstBackendConfiguration.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
	@JsonProperty("ename")
	private String ename;
	@JsonProperty("email")
	private String email;
	@JsonProperty("esalary")
	private long esalary;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getEsalary() {
		return esalary;
	}
	public void setEsalary(long esalary) {
		this.esalary = esalary;
	}
	
	
}
