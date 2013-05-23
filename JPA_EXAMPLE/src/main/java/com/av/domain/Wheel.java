package com.av.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Embeddable
@Table(name = "Wheel")
public class Wheel implements Serializable {

	/*
	@Id
	@SequenceGenerator(name = "wheel_seq", sequenceName = "wheel_seq")
	@GeneratedValue(generator = "wheel_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "wheel_id")
	private Long id;*/

	@Override
	public String toString() {
		return "Wheel [name=" + name + "]";
	}

	@Column(name = "Name")
	private String name;

	
	public Wheel(String name) {
		super();
		this.name = name;
	}
	
	public Wheel() {
		super();
		
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Wheel other = (Wheel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
