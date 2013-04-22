package com.av.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.av.domain.Project;
import com.av.repository.ProjectRepository;

@Service("ProjectService")
@Repository
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository rep;

	public Project save(Project proj) {
		
		return rep.save(proj);
	}

}
