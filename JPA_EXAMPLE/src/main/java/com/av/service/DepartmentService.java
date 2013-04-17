package com.av.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.av.domain.Department;

public interface DepartmentService {
	@Transactional
	public List <Department> findAll();
	
}
