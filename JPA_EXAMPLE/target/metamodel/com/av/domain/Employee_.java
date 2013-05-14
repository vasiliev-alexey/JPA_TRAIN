package com.av.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SetAttribute<Employee, Project> projects;
	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile ListAttribute<Employee, VacationEntry> vacationBookings;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile SingularAttribute<Employee, Date> birthDate;
	public static volatile SingularAttribute<Employee, Double> salary;
	public static volatile SingularAttribute<Employee, Department> dept;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, Long> employee_id;
	public static volatile MapAttribute<Employee, PhoneType, String> phones;

}

