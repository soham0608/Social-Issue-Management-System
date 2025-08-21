package dao;

import com.example.SecondService.entities.User.Status;

public class ComplaintStatusRequestDto {

    private Integer complaintId;
    private Integer handledBy; // ZoneOperator ID (can be null)
    private Status status;
//    private String area;

    public ComplaintStatusRequestDto() {}

    public ComplaintStatusRequestDto(Integer complaintId, Integer handledBy, Status status) {
        this.complaintId = complaintId;
        this.handledBy = handledBy;
        this.status = status;
//        this.area = area;
    }

    // Getters and Setters
    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getHandledBy() {
        return handledBy;
    }

    public void setHandledBy(Integer handledBy) {
        this.handledBy = handledBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public String getNote() {
//        return area;
//    }
//
//    public void setNote(String area) {
//        this.area = area;
//    }
}
