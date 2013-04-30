package com.av.tests;

import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Emp;

public class LifecycleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		Emp e = new Emp();

		e.setSalary(100f);
		e.setsDate(new Date());
		e.setSname("sddd");

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

		em.getTransaction().begin();
		e.setSalary(200f);
		em.persist(e);
		em.getTransaction().commit();

		
		em.getTransaction().begin();
		em.refresh(e);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();

	}

}
