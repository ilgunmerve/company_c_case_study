package com.ilgunmerve.sebit.model;

public class Project {

	private int projectId;
	private String projectName;

	public Project() {}
	

//	@MappedCollection(idColumn = "ID", keyColumn = "CONTACT_NO")
//	private List<Project> projects;

	
	public Project(int projectId, String projectName) {
		this.projectId = projectId;
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	
}

