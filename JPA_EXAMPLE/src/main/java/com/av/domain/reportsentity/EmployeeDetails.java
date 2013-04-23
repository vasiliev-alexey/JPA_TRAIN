package com.av.domain.reportsentity;

public class EmployeeDetails {
private String empName;
private String deptName;
@Override
public String toString() {
	return "EmployeeDetails [empName=" + empName + ", deptName=" + deptName
			+ ", salary=" + salary + "]";
}
private Double salary;
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getDeptName() {
	return deptName;
}
public EmployeeDetails(String empName,  Double salary , String deptName) {
	super();
	this.empName = empName;
	this.deptName = deptName;
	this.salary = salary;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
}
