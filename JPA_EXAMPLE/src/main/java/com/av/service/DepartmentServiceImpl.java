package com.av.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.av.domain.Department;
import com.av.domain.Employee;
import com.av.repository.DeptRepository;
import com.google.common.collect.Lists;

@Service("DepartmentService")
@Repository
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DeptRepository deprep;

	public List<Department> findAll() {

		ArrayList<Department> dept = Lists.newArrayList(deprep.findAll());

		for (Department d : dept) {
			
			if (!Hibernate.isInitialized(d.getEmps()))
			{
				Hibernate.initialize(d.getEmps());
			//	int i = d.getEmps().size();
			}
		}

		return dept;
	}

}
