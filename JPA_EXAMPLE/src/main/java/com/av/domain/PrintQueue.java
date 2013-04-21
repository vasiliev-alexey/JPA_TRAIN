package com.av.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToMany( fetch = FetchType.EAGER ,     cascade =CascadeType.ALL , mappedBy = "queue")
	@OrderColumn(name="PRINT_ORDER")
	private List <PrintJob> jobs;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
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
		PrintQueue other = (PrintQueue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
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
