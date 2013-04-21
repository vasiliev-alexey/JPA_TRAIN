package com.av.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.ForeignKey;

@Entity
public class PrintJob {
	public PrintJob(String name) {
		super();
		this.name = name;
	}

	@Id
	@SequenceGenerator(name = "PRINT_JOB_SEQ", sequenceName = "PRINT_JOB_SEQ")
	@GeneratedValue(generator = "PRINT_JOB_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="PRINT_ID")
	Long id;

	@ManyToOne(targetEntity = PrintQueue.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "QUEUE_ID")
	private PrintQueue queue;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + printOrder;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
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
		PrintJob other = (PrintJob) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (printOrder != other.printOrder)
			return false;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		return true;
	}

	@Column(name = "JOB_NAME")
	private String name;

	@Column(name = "Print_ORDER")
	private int printOrder;

	public PrintJob() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrintQueue getQueue() {
		return queue;
	}

	public void setQueue(PrintQueue queue) {
		this.queue = queue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PrintJob [id=" + id +  ", name=" + name
				+ "]";
	}

}
