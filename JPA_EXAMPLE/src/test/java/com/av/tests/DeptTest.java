package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



import com.av.domain.Department;
import com.av.domain.Employee;
import com.av.service.*;

import org.hibernate.Hibernate;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeptTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		DepartmentService  ds = ctx.getBean( "DepartmentService", DepartmentService.class);
		
		for (Department d : ds.findAll()) {
	
			System.out.println(d);
		}
	}

}
