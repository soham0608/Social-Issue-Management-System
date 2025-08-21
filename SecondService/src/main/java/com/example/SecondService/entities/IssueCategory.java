package com.example.SecondService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "issue_category")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IssueCategory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issue_id;

    private String description;

	public Integer getIssueId() {
		return issue_id;
	}

	public void setIssueId(Integer issueId) {
		this.issue_id = issueId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
