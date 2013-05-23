package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Car;
import com.av.domain.Wheel;

public class CarTest {

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

		List<Wheel> list = new ArrayList<>();

		for (int i = 0; i < 6; i++) {
			list.add(new Wheel("wheel " + i));
		}

		Car c = new Car();
		c.setName("VaZ");
		c.setWheels(list);
		//
		// em.getTransaction().begin();
		// em.persist(c);
		// em.getTransaction().commit();
		//

		Query q = em.createNamedQuery("countWheel3").setParameter("count", Long.valueOf(5));
		List l = q.getResultList();
		for (Object object : l) {
			if (object instanceof Object[]) {
				Object[] row = (Object[]) object;

				System.out.println(row[0] + "   " + row[1] );
			} else {
				System.out.println(object);
			}

		}

	}

}
