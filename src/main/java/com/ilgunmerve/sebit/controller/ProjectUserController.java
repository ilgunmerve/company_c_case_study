package com.ilgunmerve.sebit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    	try {
    		projectUserDAO.assignUser(projectId,userId );
    	}
    	catch (DataAccessException ex)
    	{
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Mapping Already Exists");
    	}
        
    }
    
    @DeleteMapping("/projects/{projectId}/users/{userId}")
    void deleteUser(@PathVariable int projectId, @PathVariable int userId) {
        int affectedRows = projectUserDAO.delete(projectId,userId );
        if(affectedRows == 0)
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Mapping Does not Exist");
    }
    
    @GetMapping("/projectBudget")
    List<Map<String,Object>> getProjectBudget() {
    	return projectUserDAO.listProjectsByBudget();
    }
    
    @GetMapping("/projectBudget/greaterThen={minBudget}")
    List<Map<String,Object>> getProjectBudget(@PathVariable int minBudget) {
    	return projectUserDAO.listProjectsByBudget(minBudget);
    }
    
    
	
}
