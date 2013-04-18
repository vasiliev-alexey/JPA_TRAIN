package com.av.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PrintJob {
	public PrintJob(String name) {
		super();
		this.name = name;
	}
	@Id
	@SequenceGenerator(name = "PRINT_JOB_SEQ" , sequenceName = "PRINT_JOB_SEQ")
	@GeneratedValue (generator ="PRINT_JOB_SEQ" , strategy= GenerationType.SEQUENCE)
	Long id;
	
	@ManyToOne(targetEntity= PrintQueue.class )
//	@JoinColumn(name="QUEUE_ID")
	private PrintQueue queue;
	
	@Column(name= "JOB_NAME")
	private String name;
	
	@Column(name ="Print_ORDER")
	private  int printOrder  ;
	
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
		return "PrintJob [id=" + id + ", queue=" + queue + ", name=" + name
				+ "]";
	}
	

}
