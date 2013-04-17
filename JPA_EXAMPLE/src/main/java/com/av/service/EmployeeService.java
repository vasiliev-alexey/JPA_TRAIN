package com.av.service;

import java.util.List;

import com.av.domain.Employee;

public interface EmployeeService {

	public List <Employee> findAll();
	
	public Employee Save(Employee emp);
	
	public void remove(Long id);
}
