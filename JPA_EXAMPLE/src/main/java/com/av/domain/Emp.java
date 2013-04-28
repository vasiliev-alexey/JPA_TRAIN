package com.av.domain;

import java.util.Date;

import javax.management.DescriptorKey;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Emps")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name= "Emp_Type" , discriminatorType=DiscriminatorType.STRING)
public  class Emp {

	@Id
	@SequenceGenerator(name = "emps_seq", sequenceName = "emps_seq")
	@GeneratedValue(generator = "emps_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "EMPLOYEE_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "s_date")
	@Temporal(TemporalType.DATE)
	private Date sDate;
	

	//private String empType;

	
	
	
	
	
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	@Column(name = "salary")
	private Float salary;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getsDate() {
		return sDate;
	}
	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sDate=" + sDate
				+ ", salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sDate == null) ? 0 : sDate.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sDate == null) {
			if (other.sDate != null)
				return false;
		} else if (!sDate.equals(other.sDate))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

}
