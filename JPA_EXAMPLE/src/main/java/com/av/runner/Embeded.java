package com.av.runner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.Address;
import com.av.domain.Employee;
import com.av.domain.VacationEntry;
import com.av.service.EmployeeService;

public class Embeded {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		EmployeeService es = ctx.getBean( "EmployeeService" ,  EmployeeService.class);

		Employee e = new Employee();
		e.setBirthDate(new Date());
		e.setFirstName("Alex");
		e.setLastName("VASILIEV");
		e.setEmail("tsts");
		
		
		Address a = new Address();
		a.setCity("Moscow");
		a.setState("Russia");
		a.setZip("110000");
		a.setStreet("VERHNAI");
		
		e.setAddress(a);
		
		
		
		//es.Save(e);
		
		
		for (Employee emp : es.findAll()) {
			if (emp.getEmail().startsWith("tsts")) {
				es.remove(emp.getEmployee_id());
			}
		}
		
		Date c=  new Date();
		c.UTC(1981, 12, 18, 0, 0, 0);
		
		List<Date> listCal = new ArrayList<Date>();
		listCal.add(c);
		VacationEntry v = new VacationEntry();
		v.setDaysTaken(10);
		v.setStartDate(c);
		
		List <VacationEntry> data = new ArrayList();
		data.add(v);
		
		e.setVacationBookings(data);
		es.Save(e);
		
		for (Employee emp : es.findAll()) {
			System.out.println(emp);
		}
		
	}

}
