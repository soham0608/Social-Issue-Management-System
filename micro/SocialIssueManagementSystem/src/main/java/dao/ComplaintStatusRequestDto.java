////package dao;
////
////import com.socialissuemanagement.demo.entities.ComplaintStatus.Status;
////
////
////public class ComplaintStatusRequestDto {
////
////    private Integer complaintId;
////    private Integer handledBy; // ZoneOperator ID (can be null)
////    
////    private Status status;
//////    private String area;
////
////    public ComplaintStatusRequestDto() {}
////
////    public ComplaintStatusRequestDto(Integer complaintId, Integer handledBy, Status status) {
////        this.complaintId = complaintId;
////        this.handledBy = handledBy;
////        this.status = status;
//////        this.area = area;
////    }
////
////    // Getters and Setters
////    public Integer getComplaintId() {
////        return complaintId;
////    }
////
////    public void setComplaintId(Integer complaintId) {
////        this.complaintId = complaintId;
////    }
////
////    public Integer getHandledBy() {
////        return handledBy;
////    }
////
////    public void setHandledBy(Integer handledBy) {
////        this.handledBy = handledBy;
////    }
////
////    public Status getStatus() {
////        return status;
////    }
////
////    public void setStatus(Status status) {
////        this.status = status;
////    }
////
//////    public String getNote() {
//////        return area;
//////    }
//////
//////    public void setNote(String area) {
//////        this.area = area;
//////    }
////}
//
//
//package dao;
//
//import com.socialissuemanagement.demo.entities.ComplaintStatus.Status;
//
//public class ComplaintStatusRequestDto {
//
//    private Integer complaintId;
//    private Integer handledById; // <-- This must exist!
//    private Status status;
//    private String note;
//
//    public ComplaintStatusRequestDto() {}
//
//    public Integer getComplaintId() {
//        return complaintId;
//    }
//
//    public void setComplaintId(Integer complaintId) {
//        this.complaintId = complaintId;
//    }
//
//    public Integer getHandledById() {  // <-- This must exist!
//        return handledById;
//    }
//
//    public void setHandledById(Integer handledById) {
//        this.handledById = handledById;
//    }
//
//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//}
//

package dao;

import com.socialissuemanagement.demo.entities.ComplaintStatus.Status;

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

