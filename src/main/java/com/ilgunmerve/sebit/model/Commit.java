package com.ilgunmerve.sebit.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Commit {

	private int userId;
	private int projectId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date day;
	private int commitCount;

	public Commit() {}

	public Commit(int userId, int projectId, Date day, int commitCount) {
		this.userId = userId;
		this.projectId = projectId;
		this.day = day;
		this.commitCount = commitCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getCommitCount() {
		return commitCount;
	}

	public void setCommitCount(int commitCount) {
		this.commitCount = commitCount;
	}
	
	@Override
	public String toString() {
		return "Commit [userId=" + userId + ", projectId=" + projectId + ", day=" + day + ", commitCount=" + commitCount
				+ "]";
	}
	
	
	
}
