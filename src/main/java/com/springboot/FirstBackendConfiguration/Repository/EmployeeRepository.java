package com.springboot.FirstBackendConfiguration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.FirstBackendConfiguration.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
