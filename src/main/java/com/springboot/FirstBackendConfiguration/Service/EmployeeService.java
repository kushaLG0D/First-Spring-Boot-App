package com.springboot.FirstBackendConfiguration.Service;

import java.util.List;

import com.springboot.FirstBackendConfiguration.Model.Employee;
import com.springboot.FirstBackendConfiguration.request.EmployeeRequest;

public interface EmployeeService {
	Employee saveEmployee(EmployeeRequest e);

	List<Employee> getAllEmployee(); 
	
	Employee getEmployeeByID(long id);
	
	Employee updateEmployee(EmployeeRequest e,long id);
	
	void deleteEmployee(long id);
	
}
