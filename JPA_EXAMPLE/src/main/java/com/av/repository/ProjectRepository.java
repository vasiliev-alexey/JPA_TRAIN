package com.av.repository;

import org.springframework.data.repository.CrudRepository;

import com.av.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
