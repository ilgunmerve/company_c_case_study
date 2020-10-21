package com.ilgunmerve.sebit.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommitFilter {

	private int projectId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	public CommitFilter(int projectId, Date startDate, Date endDate) {
		super();
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "CommitFilter [projectId=" + projectId + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
