package com.operatorservice.demo.dao;

import com.operatorservice.demo.entity.ComplaintStatus.Status;

public class ComplaintStatusRequestDto {

    private Integer complaintId;
    private Integer handledById; // Only the ID
    private Status status;
    private String note;

    public ComplaintStatusRequestDto() {}

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getHandledById() {
        return handledById;
    }

    public void setHandledById(Integer handledById) {
        this.handledById = handledById;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

