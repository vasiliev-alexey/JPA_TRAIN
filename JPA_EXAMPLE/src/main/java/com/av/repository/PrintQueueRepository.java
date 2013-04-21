package com.av.repository;

import org.springframework.data.repository.CrudRepository;

import com.av.domain.PrintQueue;
import com.av.service.PrintQueueService;

public interface PrintQueueRepository extends CrudRepository<PrintQueue, Long> {
	
}
