package com.av.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Department;
import com.av.domain.Employee;
import com.av.domain.reportsentity.EmployeeDetails;

public class QueryTester {

	public static void printResult(Object result) throws Exception {
		if (result == null) {
			System.out.print("NULL");
		} else if (result instanceof Object[]) {
			Object[] row = (Object[]) result;
			System.out.print("[");
			for (int i = 0; i < row.length; i++) {
				printResult(row[i]);
			}
			System.out.print("]");
		} else if (result instanceof Long || result instanceof Double
				|| result instanceof String) {
			System.out.print(result.getClass().getName() + ": " + result);
		} else {
			System.out.print(ReflectionToStringBuilder.toString(result,
					ToStringStyle.SHORT_PREFIX_STYLE));

		}
		System.out.println();
	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
				"/META-INF/spring/app-context.xml");
		// ctx.refresh();

		EntityManagerFactory emf = ctx.getBean(EntityManagerFactory.class);

		EntityManager em = emf.createEntityManager();

		if (1 == 2) {
			// TypedQuery<Employee> q =
			// em.createQuery("select e.firstName , e.dept.deptName from Employee e ",
			// Employee.class);
			Query q = em
					.createQuery("select e.firstName , e.salary from Employee e ");
			List o = q.getResultList();

			try {
				if (o.size() > 0) {
					int count = 0;
					for (Object object : o) {
						printResult(object);
					}
				} else {
					System.out.println("0 results returned");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		TypedQuery<EmployeeDetails> query = em
				.createQuery(
						"select NEW com.av.domain.reportsentity.EmployeeDetails(e.firstName , e.salary , e.dept.deptName) from Employee e ",
						EmployeeDetails.class);

		List<EmployeeDetails> listRep = query.getResultList();

		for (EmployeeDetails employeeDetails : listRep) {
			System.out.println(employeeDetails);
		}

		System.out.println("------------------------------------------");

		// TypedQuery<Department> q1 = em.createQuery(
		// "select distinct d from Department d left join fetch d.emps",
		// Department.class);
		TypedQuery<Department> q1 = em
				.createQuery(
						"select distinct d from Department d where (select count(e) from d.emps e)> 0  order by d.emps.size desc",
						Department.class);
		List<Department> dlist = q1.getResultList();

		for (Department department : dlist) {
			System.out.println(department);
		}
		System.out.println("------------------------------------------");

		Query q2 = em.createQuery("select d.deptName , avg(e.salary) "
				+ "from Department d join d.emps e "
				+ "group by d.deptName having avg(e.salary) > 5000");

		List o = q2.getResultList();
		try {
			if (o.size() > 0) {
				int count = 0;
				for (Object object : o) {
					printResult(object);
				}
			} else {
				System.out.println("0 results returned");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
