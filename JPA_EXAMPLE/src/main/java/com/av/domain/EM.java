package com.av.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MAP_EMP")
@Access(AccessType.FIELD)
public class EM {

	String name;

	@Id
	@SequenceGenerator(name = "MAP_EMP_SEQ", sequenceName = "MAP_EMP_SEQ")
	@GeneratedValue(generator = "MAP_EMP_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name = "EMPLOYEE_ID")
	Long id;

	// ////////////////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EM [name=" + name + ", id=" + id + "]";
	}
}
