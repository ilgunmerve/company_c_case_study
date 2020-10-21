package com.ilgunmerve.sebit.dao;

import java.util.List;
import java.util.Map;

import com.ilgunmerve.sebit.model.User;

public interface ProjectUserDAO {

	int assignUser(int projectId,int userId);
	int delete(int projectId, int userId);
	List<User> listUsersbyProject(int projectId);
	List<Map<String, Object>> listProjectsByBudget();
	List<Map<String, Object>> listProjectsByBudget(int minBudget);
}
