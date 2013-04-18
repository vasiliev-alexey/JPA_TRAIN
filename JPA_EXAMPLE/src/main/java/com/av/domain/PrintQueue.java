package com.av.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table (name = "PRINTQUEUE")
public class PrintQueue {

	@Id
	@SequenceGenerator(name = "PRINT_QUEUE_SEQ" , sequenceName = "PrintQueue_SEQ")
	@GeneratedValue(generator = "PRINT_QUEUE_SEQ" , strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private  Long id;
	@Column(name = "QUEUENAME")
	private  String name;
	
	@OneToMany(mappedBy= "queue" , fetch = FetchType.EAGER ,  cascade =CascadeType.ALL)
	@OrderColumn(name="PRINT_ORDER")
	private List <PrintJob> jobs;
	
	
	public List<PrintJob> getJobs() {
		return jobs;
	}
	public void setJobs(List<PrintJob> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "PrintQueue [id=" + id + ", name=" + name + ", jobs=" + jobs
				+ "]";
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
	
}
