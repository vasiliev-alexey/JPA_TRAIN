package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Department;
import com.av.domain.Department_;
import com.av.domain.Employee;
import com.av.domain.Employee_;
import com.av.domain.reportsentity.EmployeeDetails;

public class CriteriaSearch {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"/META-INF/spring/app-context.xml");
		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();

		/*
		 * if (1==2 ) { CriteriaBuilder cb = em.getCriteriaBuilder();
		 * CriteriaQuery<Department> q = cb.createQuery(Department.class);
		 * Root<Department> dept = q.from(Department.class); Join<Department,
		 * Employee> emp = dept.join("emps" , JoinType.INNER);
		 * 
		 * q.select(dept).distinct(true); q.where(cb.equal(dept,
		 * emp.get("dept"))).where( cb.equal(emp.get("lastName"), "Hartstein"));
		 * 
		 * List<Department> list = new ArrayList<Department>();
		 * TypedQuery<Department> result = em.createQuery(q);
		 * 
		 * list = result.getResultList();
		 * 
		 * for (Department department : list) { System.out.println(department);
		 * } }
		 */

		/*
		 * CriteriaBuilder cb1 = em.getCriteriaBuilder();
		 * CriteriaQuery<EmployeeDetails> q2 =
		 * cb1.createQuery(EmployeeDetails.class); Root<Employee> r =
		 * q2.from(Employee.class); Join<Employee , Department> ddd =
		 * r.join("dept", JoinType.LEFT); q2.multiselect( r.get("lastName"),
		 * r.get("salary") , ddd.get("deptName") );
		 * 
		 * TypedQuery<EmployeeDetails> qw = em.createQuery(q2);
		 * 
		 * List <EmployeeDetails> result = qw.getResultList();
		 * 
		 * for (EmployeeDetails employeeDetails : result) {
		 * System.out.println(employeeDetails); }
		 */
		CriteriaBuilder cb2 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> q2 = cb2.createTupleQuery();
		Root<Department> depts = q2.from(Department.class);
		Join<Department, Employee> emps = depts.join("emps", JoinType.INNER);

		q2.multiselect(depts.get(Department_.deptName),
				cb2.sum(emps.get(Employee_.salary).as(Double.class))).groupBy(
				depts.get("deptName"));
		q2.orderBy(cb2.asc(depts.get(Department_.deptName)) );

		List list = new ArrayList();
		list = em.createQuery(q2).getResultList();

		
		if (list.size() != 0) {
			for (Object object : list) {
				System.out.print( ((Tuple)object).get(0) );
				System.out.print (" = " );
				System.out.println( ((Tuple)object).get(1) );
			}
		}
		
	}

}
