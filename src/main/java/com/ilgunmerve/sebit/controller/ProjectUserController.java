package com.ilgunmerve.sebit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilgunmerve.sebit.dao.ProjectUserDAO;
import com.ilgunmerve.sebit.model.User;

@RestController
public class ProjectUserController {

	@Autowired    
    ProjectUserDAO projectUserDAO;
	
    @GetMapping("/projects/{projectId}/users")
    List<User> getProjectUsers(@PathVariable int projectId) {
    	return projectUserDAO.listUsersbyProject(projectId);
    }
    
    @PutMapping("/projects/{projectId}/users/{userId}")
    void assignUser(@PathVariable int projectId, @PathVariable int userId) {
        projectUserDAO.assignUser(projectId,userId );
    }
    
    @DeleteMapping("/projects/{projectId}/users/{userId}")
    void deleteUser(@PathVariable int projectId, @PathVariable int userId) {
        projectUserDAO.delete(projectId,userId );
    }
    
    
	
}
