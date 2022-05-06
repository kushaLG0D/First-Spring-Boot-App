package com.springboot.FirstBackendConfiguration.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.FirstBackendConfiguration.Model.Employee;
import com.springboot.FirstBackendConfiguration.Service.EmployeeService;
import com.springboot.FirstBackendConfiguration.request.EmployeeRequest;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	//POST - Create a employee
	@PostMapping
	public Employee saveEmployee(@RequestBody EmployeeRequest e)
	{
		return employeeService.saveEmployee(e);
	}
	
	//GET - All employee data;
	@GetMapping("/all")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee getEmbloyeeById(@PathVariable long id)
	{
		return employeeService.getEmployeeByID(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody EmployeeRequest er,@PathVariable long id)
	{
		return employeeService.updateEmployee(er, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id)
	{
		employeeService.deleteEmployee(id);
	}
}
