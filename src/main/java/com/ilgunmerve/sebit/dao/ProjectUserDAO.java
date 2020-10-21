package com.ilgunmerve.sebit.dao;

import java.util.List;

import com.ilgunmerve.sebit.model.User;

public interface ProjectUserDAO {

	public int assignUser(int projectId,int userId);
	public int delete(int projectId, int userId);
	public List<User> listUsersbyProject(int projectId); 
}
