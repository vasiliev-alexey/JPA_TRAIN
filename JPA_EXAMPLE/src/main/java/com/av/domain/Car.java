package com.av.domain;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.av.domain.Wheel;

@Entity
@Table(name = "Car")
@NamedQueries({
		@NamedQuery(name = "countWheel", query = "select c.name ,  size(c.wheels) from Car c group by c.name"),
		@NamedQuery(name = "countWheel2", query = "select c from Car c where  size(c.wheels) > :count"),
		@NamedQuery(name = "countWheel3", query = "select c from Car c where  (select count(w.name) from c.wheels w) >:count ")})
public class Car {

	@Id
	@Column(name = "Id")
	@SequenceGenerator(name = "car_seq", sequenceName = "car_seq")
	@GeneratedValue(generator = "car_seq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ElementCollection(fetch = FetchType.EAGER, targetClass = Wheel.class)
	@CollectionTable(name = "wheel", joinColumns = @JoinColumn(name = "car_id"))
	List<Wheel> wheels;

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", wheels=" + wheels + "]";
	}

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

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

}
