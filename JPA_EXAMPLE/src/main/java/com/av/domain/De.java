package com.av.domain;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MAP_DEPT")
public class De {

	@Id
	@Column(name = "DEPT_ID")
	@SequenceGenerator(name = "MAP_DEPT_SEQ", sequenceName = "MAP_DEPT_SEQ")
	@GeneratedValue(generator = "MAP_DEPT_SEQ", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "NAME")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "MAP_DEPT_EMP", joinColumns = @JoinColumn(name = "DEPT_ID"), inverseJoinColumns = @JoinColumn(name = "EMP_ID"))
	@MapKeyColumn(name = "CUBE_ID")
	private Map<String, EM> employeeByCubicle;

	// ///////////////////////////////////////////
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		
		String result;
		result = "De [id=" + id + ", name=" + name + ", employeeByCubicle=";
	
		for (String s :employeeByCubicle.keySet() ) {
			result  = result + s + " ";
			
		}
		
		return result;
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

	public Map<String, EM> getEmployeeByCubicle() {
		return employeeByCubicle;
	}

	public void setEmployeeByCubicle(Map<String, EM> employeeByCubicle) {
		this.employeeByCubicle = employeeByCubicle;
	}

}
