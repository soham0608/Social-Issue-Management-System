package com.operatorservice.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "citizen_complaint")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CitizenComplaint {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer complaint_id;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id")
    private IssueCategory issue_category;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private Area area;

    private String description;

    private LocalDateTime submitted_at;
    
   /* @OneToOne
    @JoinColumn(name = "complaint_id", referencedColumnName = "complaint_id")
    @MapsId
    private CitizenComplaint complaint; */
    
    
    @Column(name = "action_status")
    private int actionStatus = 0;

    // Getters and Setters
    public int getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(int actionStatus) {
        this.actionStatus = actionStatus;
    }

    //Getter Setter
	public Integer getComplaintId() {
		return complaint_id;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaint_id = complaintId;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public IssueCategory getIssueCategory() {
		return issue_category;
	}

	public void setIssueCategory(IssueCategory issueCategory) {
		this.issue_category = issueCategory;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getSubmittedAt() {
		return submitted_at;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submitted_at = submittedAt;
	}
	
	

	
}
