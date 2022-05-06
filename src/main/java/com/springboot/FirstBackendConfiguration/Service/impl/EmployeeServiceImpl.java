package com.springboot.FirstBackendConfiguration.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springboot.FirstBackendConfiguration.Exception.ResourceNotFoundException;
import com.springboot.FirstBackendConfiguration.Model.Employee;
import com.springboot.FirstBackendConfiguration.Repository.EmployeeRepository;
import com.springboot.FirstBackendConfiguration.Service.EmployeeService;

import com.springboot.FirstBackendConfiguration.request.EmployeeRequest;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	@Override
	public Employee saveEmployee(EmployeeRequest er) {
		Employee e1=new Employee();
		BeanUtils.copyProperties(er, e1);
//		e1.setEmail(e.getEmail());
//		e1.setEname(e.getEname());
//		e1.setEsalary(e.getEsalary());
		employeeRepository.save(e1);
		return e1;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByID(long id) {
		
		Optional <Employee> emp= employeeRepository.findById(id);
		if(emp.isPresent())
		{
			return emp.get();
		}
		else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}
		
		//return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
	}

	@Override
	public Employee updateEmployee(EmployeeRequest e, long id) {
		// Check employee Present
			Employee uemp= employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
			BeanUtils.copyProperties(e, uemp);
			employeeRepository.save(uemp);
			return uemp;
		}
	

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
		}
	
	
}
