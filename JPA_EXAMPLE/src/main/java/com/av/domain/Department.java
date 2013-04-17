package com.av.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Department {

	@Id
	@Column(name = "Id")
	@SequenceGenerator(name = "DEPT_SEQ", sequenceName = "DEPT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPT_SEQ")
	private Long id;

	@Column(name = "Department_name")
	private String deptName;

	@OneToMany(mappedBy = "dept", targetEntity = Employee.class  )
	@OrderBy("firstName ASC")
	private List<Employee> emps;
//////////////////////////////////////////////////
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + ", emps="
				+ emps + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

}
