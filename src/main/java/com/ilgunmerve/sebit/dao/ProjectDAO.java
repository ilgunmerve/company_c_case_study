package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import com.ilgunmerve.sebit.model.Project;

public interface ProjectDAO {

	int save(Project project);		
	Optional<Project> get(int projectId);
	List<Project> listProject();
	
}
