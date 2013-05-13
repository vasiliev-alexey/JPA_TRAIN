package com.av.tests;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import oracle.net.aso.e;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.loader.criteria.CriteriaLoader;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.De;
import com.av.domain.EM;

public class MapEmpTest {

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
		Map<String, EM> t = new TreeMap<String, EM>();
		EM ee = new EM();
		ee.setName("RRRR");

		t.put("210", ee);
		 
		

		De e1 = new De();
		e1.setName("Dept 1");
		e1.setEmployeeByCubicle(t);

		em.getTransaction().begin();
	//	em.persist(ee);
		em.persist(e1);
		em.getTransaction().commit();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<De> cq = cb.createQuery(De.class);
		Root<De> root = cq.from(De.class);

		List<De> result = em.createQuery(cq).getResultList();

		for (De e : result) {
			System.out.println(e);
		}
	}

}
