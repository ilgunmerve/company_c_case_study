package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import com.ilgunmerve.sebit.model.Project;
import com.ilgunmerve.sebit.model.User;


public interface ProjectDAO {

	public void save(Project project);
		
	public Optional<Project> get(int projectId);

	public List<Project> listProject();
	
}
