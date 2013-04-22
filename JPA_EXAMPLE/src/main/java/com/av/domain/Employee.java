package com.av.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee")
@SecondaryTable(name = "ADDRESS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMployee_ID"))
public class Employee {

	@Id
	@SequenceGenerator(name = "EM", sequenceName = "EMP_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EM")
	private Long employee_id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "Hire_date")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Column(name = "EMAIL")
	private String email;

	@ElementCollection(targetClass = VacationEntry.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "VACATIONBOOKINGS", joinColumns = @JoinColumn(name = "employee_id"))
	private List vacationBookings;

	@ManyToOne()
	@JoinColumn(name = "department_id")
	private Department dept;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "EMP_PHONE", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
	// @JoinColumn(name= "EMPLOYEE_ID")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHONE_TYPE")
	@Column(name = "PHONE_NUMBER")
	private Map<PhoneType, String> phones;

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public Map<PhoneType, String> getPhones() {
		return phones;
	}

	public void setPhones(Map<PhoneType, String> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(table = "ADDRESS")),
			@AttributeOverride(name = "city", column = @Column(name = "CITY", table = "ADDRESS")),
			@AttributeOverride(name = "state", column = @Column(name = "STATE", table = "ADDRESS")),
			@AttributeOverride(name = "zip", column = @Column(name = "ZIP", table = "ADDRESS")) })
	private Address address;

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", birthDate="
				+ birthDate + ", email=" + email + ", vacationBookings="
				+ vacationBookings + ", phones=" + phones + ", address="
				+ address + "]";
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List getVacationBookings() {
		return vacationBookings;
	}

	public void setVacationBookings(List vacationBookings) {
		this.vacationBookings = vacationBookings;
	}

}
