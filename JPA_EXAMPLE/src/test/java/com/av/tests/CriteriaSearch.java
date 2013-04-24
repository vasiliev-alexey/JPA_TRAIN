package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Employee;

public class CriteriaSearch {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"/META-INF/spring/app-context.xml");
		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		CriteriaQuery <Employee> q = cb.createQuery(Employee.class);
		Root<Employee> emp = q.from(Employee.class);
		q.select(emp);
		q.where(cb.equal(emp.get("lastName"),"VASILIEV"));
		
		
		
		List <Employee >  list = new ArrayList<Employee>();
		TypedQuery<Employee>  result = em.createQuery(q);
		
		list  = result.getResultList();
		
		for (Employee employee : list) {
			System.out.println(employee);
		}
		
		
		
	}

}
