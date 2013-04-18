package com.av.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.av.domain.PrintJob;
import com.av.domain.PrintQueue;
import com.av.service.PrintQueueService;

public class PrintQueueTest {


	public static void fillJobs(PrintQueue q) {
	
		List<PrintJob> jobs = new ArrayList <PrintJob>();
		jobs.add(new PrintJob("Job 5"));
		jobs.add(new PrintJob("Job 2"));
		jobs.add(new PrintJob("Job 4"));
		jobs.add(new PrintJob("Job 1"));
		q.setJobs(jobs);
	}
	
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("/META-INF/spring/app-context.xml");
		ctx.refresh();

		PrintQueueService ps = ctx.getBean("PrintQueueService", PrintQueueService.class);
		
		PrintQueue q1 = new PrintQueue();
		q1.setName("Queue 1");
		
		PrintQueue q2 = new PrintQueue();
		q2.setName("Queue 2");
		
		fillJobs(q1);
		fillJobs(q2);
		
		System.out.println(q1);
		
		ps.deleteAll();
		
		
		ps.save(q1);
		ps.save(q2);
		
	
		for (PrintQueue q : ps.findAll()) {
			System.out.println(q);
		}
		
	}

}
