package com.ilgunmerve.sebit.model;

import java.sql.Date;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommitSummary {

	private int projectId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date day;
	private int[] userList;
	
	public CommitSummary() {}
	
	public CommitSummary(int projectId, Date day, int[] userList) {
		this.projectId = projectId;
		this.day = day;
		this.userList = userList;
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

	public int[] getUserList() {
		return userList;
	}

	public void setUserList(int[] userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "CommitSummary [projectId=" + projectId + ", day=" + day + ", userList=" + Arrays.toString(userList)
				+ "]";
	}
	
	
}
