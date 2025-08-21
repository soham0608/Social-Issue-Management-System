package com.operatorservice.demo.dao;

import java.time.LocalDateTime;

import com.operatorservice.demo.entity.ComplaintStatus.Status;

public class ComplaintStatusResponseDto {

    private Integer citizenId;
    private String firstName;
    private String lastName;
    private String issueCategory;
    private String areaName;
    private Status status;
    private LocalDateTime submittedAt;

    public Integer getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIssueCategory() {
		return issueCategory;
	}

	public void setIssueCategory(String issueCategory) {
		this.issueCategory = issueCategory;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}

	public ComplaintStatusResponseDto(Integer citizenId, String firstName, String lastName, String issueCategory, String areaName, Status status, LocalDateTime submittedAt) {
        this.citizenId = citizenId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.issueCategory = issueCategory;
        this.areaName = areaName;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    // Getters and setters
}

