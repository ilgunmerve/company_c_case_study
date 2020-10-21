package com.ilgunmerve.sebit.model;

public class ProjectUser {
	
	private int userId;
	private int projectId;
	
	public ProjectUser(int userId, int projectId) {
		this.userId = userId;
		this.projectId = projectId;
	}
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ProjectUser [userId=" + userId + ", projectId=" + projectId + "]";
	}
	
	

}
