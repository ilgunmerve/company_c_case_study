package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Optional;

import com.ilgunmerve.sebit.model.Project;

public interface ProjectDAO {

	public int save(Project project);
		
	public Optional<Project> get(int projectId);

	public List<Project> listProject();
	
}
