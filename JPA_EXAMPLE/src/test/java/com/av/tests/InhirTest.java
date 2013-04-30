package com.av.tests;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.ContractEmp;
import com.av.domain.Emp;
import com.av.domain.StaffEmp;

public class InhirTest {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		ContractEmp e = new  ContractEmp();
		
	//	em.remove(em.find(ContractEmp.class, new Long(400)));
		
		e.setContract("TSTS1");
		e.setSname("TestEmployee");
		e.setSalary(1000f);
		e.setsDate(new Date());
	
	
		
		StaffEmp se = new  StaffEmp();
		se.setSname("StaffTest");
		se.setRoom("3");
		se.setSalary(1234f);
		se.setsDate(new Date());
		
		em.getTransaction().begin();
		em.merge(e);
		em.merge(se);
		em.getTransaction().commit();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Emp> cq= cb.createQuery(Emp.class);
		Root<Emp> emp = cq.from(Emp.class);
		cq.select(emp);
		
		TypedQuery<Emp> tq = em.createQuery(cq);
		List<Emp>  list = tq.getResultList();
		
		for (Emp emp2 : list) {
			System.out.println(emp2);
		}
		
		
		
		
		
	}

}
