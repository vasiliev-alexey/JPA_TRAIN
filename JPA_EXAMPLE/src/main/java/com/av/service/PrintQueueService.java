package com.av.service;

import java.util.List;

import com.av.domain.PrintQueue;

public interface PrintQueueService {

	public List<PrintQueue> findAll();
	public void 	deleteAll();
	public PrintQueue save(PrintQueue q);
}
