package com.av.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.management.DescriptorKey;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.av.service.TestListener;

@Entity
@Table(name = "Emps")
@EntityListeners(TestListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Emp_Type", discriminatorType = DiscriminatorType.STRING)
@SqlResultSetMapping(name = "XXX", entities = @EntityResult(//discriminatorColumn = "Emp_Type", 
entityClass = Emp.class, fields = {
		@FieldResult(name = "id", column = "EMPLOYEE_ID"),
		@FieldResult(name = "sname", column = "dddd"),
		@FieldResult(name = "sDate", column = "S_DATE"),
		@FieldResult(name = "salary", column = "SALARY")}

))
public class Emp {

	@Id
	@SequenceGenerator(name = "emps_seq", sequenceName = "emps_seq")
	@GeneratedValue(generator = "emps_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "EMPLOYEE_ID")
	private BigDecimal id;
	@Column(name = "S_NAME")
	private String sname;
	@Column(name = "S_DATE")
	@Temporal(TemporalType.DATE)
	private Date sDate;
	@Column(name = "SALARY")
	private Float salary;

	// private String empType;

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + sname + ", sDate=" + sDate
				+ ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
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
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
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
