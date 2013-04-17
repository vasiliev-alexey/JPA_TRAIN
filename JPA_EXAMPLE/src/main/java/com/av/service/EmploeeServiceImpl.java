package com.av.service;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EmbeddableType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.av.domain.Employee;
import com.av.repository.EmployeeRepository;
import com.google.common.collect.Lists;

@Service("EmployeeService")
@Repository
@Transactional
public class EmploeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository rep;

	public List<Employee> findAll() {

		return Lists.newArrayList(rep.findAll());
	}

	public Employee Save(Employee emp) {

		return rep.save(emp);
	}

	public void remove(Long id) {

		rep.delete(id);
	}

}
