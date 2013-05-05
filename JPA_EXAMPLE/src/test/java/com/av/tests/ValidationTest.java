package com.av.tests;

import java.util.Date;
import java.util.Locale;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.swing.Spring;

import java.util.Iterator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.validator.engine.ConstraintViolationImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Emp;
import com.av.domain.ValidEmp;

public class ValidationTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		BasicConfigurator.configure();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		ValidEmp e = new ValidEmp();

		e.setSalary(100f);
		e.setsDate(new Date());
		// e.setSname("sddd");
		
		ValidatorFactory factory =
				Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		Set<ConstraintViolation<ValidEmp>> s  = validator.validate(e, Default.class);
		Iterator<ConstraintViolation<ValidEmp>> i = s.iterator();
		while (i.hasNext()) {
			ConstraintViolation<ValidEmp> cv = i.next();
			System.out.println("CV Message: === +++ ===: " + cv.getInvalidValue() + " = " 
					+ cv.getMessage());
		}
		
		
		
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (RollbackException e1) {

			System.out.println(e1.getLocalizedMessage());

			
			
			
		} catch (ConstraintViolationException e2) {
			
			System.out.println("++++++++++++++++++++++++++");

		}

	}

}
