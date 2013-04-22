package com.av.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.EntityManager;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Address;
import com.av.domain.Employee;
import com.av.domain.PhoneType;
import com.av.domain.Project;
import com.av.service.EmployeeService;
import com.av.service.ProjectService;

public class EmpTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EmployeeService es = ctx.getBean("EmployeeService",
				EmployeeService.class);

		try {
			Long emid = es.findByLastName("VASILIEV").getEmployee_id();
			if (emid != null)
				es.remove(emid);
		} catch (NullPointerException e) {

		}

		Employee e = new Employee();
		e.setBirthDate(new Date());
		e.setFirstName("Alex");
		e.setLastName("VASILIEV");
		e.setEmail("tsts");

		List<Employee> emp = new ArrayList<Employee>();
		emp.add(e);

		Project p = new Project();
		p.setName("JPA");
		ProjectService ps = ctx.getBean("ProjectService", ProjectService.class);
		ps.save(p);
		p.setEmployees(emp);

		Set<Project> projects = new HashSet<Project>();
		projects.add(p);

		e.setProjects(projects);
		p.setEmployees(emp);

		Address a = new Address();
		a.setCity("Moscow");
		a.setState("Russia");
		a.setZip("110000");
		a.setStreet("VERHNAI");

		e.setAddress(a);

		Map<PhoneType, String> phone = new TreeMap<PhoneType, String>();
		phone.put(PhoneType.HOME, "11111");
		phone.put(PhoneType.WORK, "22222");

		e.setPhones(phone);
		es.Save(e);

		for (Employee ed : es.findAll()) {
			System.out.println(ed);
		}

		// EntityManager em ;

	}

}
