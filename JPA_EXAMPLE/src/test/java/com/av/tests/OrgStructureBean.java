package com.av.tests;

import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Emp;
import com.av.domain.Employee;

public class OrgStructureBean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		
		
		
		String sqlQuery = "SELECT EMPLOYEE_ID,  S_NAME as dddd,  S_DATE,  SALARY  FROM EMPS ";

		Query q  =  em.createNativeQuery(sqlQuery  , "XXX");
		System.out.println("00000000000000000000000000");
		
		
		
		List<Emp> list = q.getResultList();
		
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
	
		

	}
}
