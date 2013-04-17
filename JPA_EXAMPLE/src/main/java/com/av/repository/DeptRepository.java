package com.av.repository;

import org.springframework.data.repository.CrudRepository;

import com.av.domain.Department;
import com.av.domain.Employee;

public interface DeptRepository extends CrudRepository<Department, Long>{

}
