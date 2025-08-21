package com.socialissuemanagement.demo.entities;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "complaint_status")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComplaintStatus {

	@Id
    private Integer complaint_id;

    @OneToOne
    @JoinColumn(name = "complaint_id", referencedColumnName = "complaint_id")
    @MapsId
    private CitizenComplaint complaint;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "handled_by", referencedColumnName = "operator_id")
    private ZoneOperator handled_by;

    private String note;

    public enum Status {
        REGISTERED,
        IN_PROGRESS,
        RESOLVED
    }



	public Integer getComplaintId() {
		return complaint_id;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaint_id = complaintId;
	}

	public CitizenComplaint getComplaint() {
		return complaint;
	}

	public void setComplaint(CitizenComplaint complaint) {
		this.complaint = complaint;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updated_at = updatedAt;
	}

	public ZoneOperator getHandledBy() {
		return handled_by;
	}

	public void setHandledBy(ZoneOperator handledBy) {
		this.handled_by = handledBy;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	
    
    
}
