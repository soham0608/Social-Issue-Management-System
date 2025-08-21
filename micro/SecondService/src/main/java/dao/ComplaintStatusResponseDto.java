package dao;

import java.time.LocalDateTime;

import com.example.SecondService.entities.User.Status;




public class ComplaintStatusResponseDto {
    private Integer citizenId;
    private String Fname;
    private String Lname;
    private String issueCategory;
    private String area;
    private Status status;
    private LocalDateTime submittedAt;

    public ComplaintStatusResponseDto(Integer citizenId, String Fname, String Lname, String issueCategory,
                                      String area, Status status, LocalDateTime submittedAt) {
        this.citizenId = citizenId;
        this.Fname = Fname;
        this.Lname = Lname;
        this.issueCategory = issueCategory;
        this.area = area;
        this.status = status;
        this.submittedAt = submittedAt;
    }

    // Getters and setters
    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getFname() {
        return Fname;
    }

    public void Fname(String Fname) {
        this.Fname = Fname;
    }
    
    public String getLname() {
        return Lname;
    }
    
    public void Lname(String Lname) {
        this.Lname = Lname;
    }

    public String getIssueCategory() {
        return issueCategory;
    }

    public void setIssueCategory(String issueCategory) {
        this.issueCategory = issueCategory;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
}
