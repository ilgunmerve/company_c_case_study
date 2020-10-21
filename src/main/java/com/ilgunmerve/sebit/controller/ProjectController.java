package com.ilgunmerve.sebit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilgunmerve.sebit.dao.ProjectDAO;
import com.ilgunmerve.sebit.model.Project;

@RestController
public class ProjectController {

	@Autowired    
    ProjectDAO projectDAO;  
	
    @GetMapping("/projects")
    List<Project> findAll() {
        return projectDAO.listProject();
    }
    
    @PostMapping("/projects")
    int newProject(@RequestBody Project newProject) {
        return projectDAO.save(newProject);
    }
    
 // Find
    @GetMapping("/projects/{id}")
    Optional<Project> findOne(@PathVariable int id) {
        return projectDAO.get(id);
    }
}
