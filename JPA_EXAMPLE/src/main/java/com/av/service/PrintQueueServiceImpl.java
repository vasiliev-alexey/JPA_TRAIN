package com.av.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.av.domain.PrintJob;
import com.av.domain.PrintQueue;
import com.av.repository.PrintQueueRepository;
import com.google.common.collect.Lists;

@Service("PrintQueueService")
@Repository
public class PrintQueueServiceImpl implements PrintQueueService {

	@Autowired
	PrintQueueRepository rep;

	@Autowired
	EntityManagerFactory emf;
	
	public List<PrintQueue> findAll() {

		return Lists.newArrayList(rep.findAll());
	}

	public PrintQueue save(PrintQueue q) {

		EntityManager manger = emf.createEntityManager();
	//	emf.createEntityManager().merge(q);
		manger.getTransaction().begin();
		
		manger.merge(q);
		manger.persist(q);
		manger.refresh(q);
		
		for (PrintJob pj : q.getJobs()) {
			manger.persist(pj);
		}
		
		
	
		manger.getTransaction().commit();
		 return q;
		 
		 
	}

	public void deleteAll() {
		rep.deleteAll();

	}

}
