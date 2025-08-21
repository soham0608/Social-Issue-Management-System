//package dao;
//
//import java.time.LocalDateTime;
//
//import com.socialissuemanagement.demo.entities.ComplaintStatus.Status;
//
//public class ComplaintStatusResponseDto {
//    private Integer citizenId;
//    private String Fname;
//    private String Lname;
//    private String issueCategory;
//    private String area;
//    private Status status;
//    private LocalDateTime submittedAt;
//
//    public ComplaintStatusResponseDto(Integer citizenId, String Fname, String Lname, String issueCategory,
//                                      String area, Status status, LocalDateTime submittedAt) {
//        this.citizenId = citizenId;
//        this.Fname = Fname;
//        this.Lname = Lname;
//        this.issueCategory = issueCategory;
//        this.area = area;
//        this.status = status;
//        this.submittedAt = submittedAt;
//    }
//
//    // Getters and setters
//    public Integer getCitizenId() {
//        return citizenId;
//    }
//
//    public void setCitizenId(Integer citizenId) {
//        this.citizenId = citizenId;
//    }
//
//    public String getFname() {
//        return Fname;
//    }
//
//    public void Fname(String Fname) {
//        this.Fname = Fname;
//    }
//    
//    public String getLname() {
//        return Lname;
//    }
//    
//    public void Lname(String Lname) {
//        this.Lname = Lname;
//    }
//
//    public String getIssueCategory() {
//        return issueCategory;
//    }
//
//    public void setIssueCategory(String issueCategory) {
//        this.issueCategory = issueCategory;
//    }
//
//    public String getArea() {
//        return area;
//    }
//
//    public void setArea(String area) {
//        this.area = area;
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
//    public LocalDateTime getSubmittedAt() {
//        return submittedAt;
//    }
//
//    public void setSubmittedAt(LocalDateTime submittedAt) {
//        this.submittedAt = submittedAt;
//    }
//}

package dao;

import java.time.LocalDateTime;

import com.socialissuemanagement.demo.entities.ComplaintStatus.Status;

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

