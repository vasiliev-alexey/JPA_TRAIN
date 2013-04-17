package com.av.repository;

import org.springframework.data.repository.CrudRepository;

import com.av.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
