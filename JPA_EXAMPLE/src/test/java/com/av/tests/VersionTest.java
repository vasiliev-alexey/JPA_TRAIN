package com.av.tests;

import java.util.Locale;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Emp;

public class VersionTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		Emp e = new Emp();
		e.setSalary(10000f);
		e.setsDate(new Date());

		em.getTransaction().begin();

		em.persist(e);
		em.getTransaction().commit();

		e.setSalary(200f);
		System.out.println(e);

		em.getTransaction().begin();

		em.persist(e);
		em.getTransaction().commit();
		System.out.println(e);
		//
		em.getTransaction().begin();
	//	em.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		
		try {
			Thread.currentThread().sleep(20000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		em.getTransaction().commit();

		e.setSname("New Name");

		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			System.out.println(e);
		} catch (Exception e1) {
			System.out.println("=========================");
			System.out.println(e1.getCause());
			e1.printStackTrace();
		}
	}

}
