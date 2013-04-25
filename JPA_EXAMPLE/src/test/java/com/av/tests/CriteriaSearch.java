package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Department;
import com.av.domain.Employee;

public class CriteriaSearch {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"/META-INF/spring/app-context.xml");
		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Department> q = cb.createQuery(Department.class);
		Root<Department> dept = q.from(Department.class);
		Join<Department, Employee> emp = dept.join("emps" , JoinType.INNER);

		q.select(dept).distinct(true);
		q.where(cb.equal(dept, emp.get("dept"))).where(
				cb.equal(emp.get("lastName"), "Hartstein"));

		List<Department> list = new ArrayList<Department>();
		TypedQuery<Department> result = em.createQuery(q);

		list = result.getResultList();

		for (Department department : list) {
			System.out.println(department);
		}

	}

}
