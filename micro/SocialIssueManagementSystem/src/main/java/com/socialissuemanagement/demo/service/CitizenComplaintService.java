package com.socialissuemanagement.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialissuemanagement.demo.entities.Area;
import com.socialissuemanagement.demo.entities.Citizen;
import com.socialissuemanagement.demo.entities.CitizenComplaint;
import com.socialissuemanagement.demo.entities.IssueCategory;
import com.socialissuemanagement.demo.repository.CitizenComplaintRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenComplaintService {

    @Autowired
    private CitizenComplaintRepository citizenComplaintRepository;

    public CitizenComplaint createCitizenComplaint(CitizenComplaint complaint) {
        return citizenComplaintRepository.save(complaint);
    }

    public List<CitizenComplaint> getAllCitizenComplaints() {
        return citizenComplaintRepository.findAll();
    }
    
    public CitizenComplaint getCitizenComplaintById(Integer id) {
        Optional<CitizenComplaint> complaintOptional = citizenComplaintRepository.findById(id);
        return complaintOptional.orElseThrow(() -> new RuntimeException("Complaint not found with id: " + id));
    }
    
    @Autowired
    private AreaService areaService;

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private IssueCategoryService issueCategoryService;
    
    public CitizenComplaint updateCitizenComplaint(Integer id, CitizenComplaint updatedComplaint) {
        CitizenComplaint complaint = getCitizenComplaintById(id);
        if (complaint != null) {
            complaint.setCitizen(updatedComplaint.getCitizen());
            complaint.setIssueCategory(updatedComplaint.getIssueCategory());
            complaint.setArea(updatedComplaint.getArea());
            complaint.setDescription(updatedComplaint.getDescription());
            complaint.setSubmittedAt(updatedComplaint.getSubmittedAt());

            //  Update action status
            complaint.setActionStatus(updatedComplaint.getActionStatus());

            return citizenComplaintRepository.save(complaint);
        }
        return null;
    }

    
//    public CitizenComplaint updateCitizenComplaint(Integer id, CitizenComplaint updatedComplaint) {
//        CitizenComplaint complaint = getCitizenComplaintById(id);
//        
//        if (complaint != null) {
//            updatedComplaint.setComplaintId(id); //  Set the complaint ID explicitly
//
//            updatedComplaint.setCitizen(complaint.getCitizen());
//            updatedComplaint.setIssueCategory(updatedComplaint.getIssueCategory());
//            updatedComplaint.setArea(updatedComplaint.getArea());
//            updatedComplaint.setDescription(updatedComplaint.getDescription());
//            updatedComplaint.setSubmittedAt(updatedComplaint.getSubmittedAt());
//            updatedComplaint.setActionStatus(updatedComplaint.getActionStatus()); // You can now update action status too
//            
//            return citizenComplaintRepository.save(updatedComplaint); // Save the updated record
//        }
//        return null;
//    }



//    public CitizenComplaint updateCitizenComplaint(Integer id, CitizenComplaint updatedComplaint) {
//        CitizenComplaint complaint = getCitizenComplaintById(id);
//        if (complaint != null) {
//            // Fetch managed entities
//            Area area = areaService.getAreaById(updatedComplaint.getArea().getAreaId());
//            IssueCategory category = issueCategoryService.getIssueCategoryById(updatedComplaint.getIssueCategory().getIssueId());
//            Citizen citizen = citizenService.getCitizenById(updatedComplaint.getCitizen().getCid());
//
//            // Now set the managed instances
//            complaint.setCitizen(citizen);
//            complaint.setIssueCategory(category);
//            complaint.setArea(area); 
//            complaint.setDescription(updatedComplaint.getDescription());
//            complaint.setSubmittedAt(updatedComplaint.getSubmittedAt());
//            complaint.setActionStatus(updatedComplaint.getActionStatus()); // If you're modifying this
//
//            return citizenComplaintRepository.save(complaint);
//        }
//        return null;
//    }


//    public CitizenComplaint getCitizenComplaintById(Integer id) {
//        return citizenComplaintRepository.findById(id).orElse(null);
//    }

    
//    public CitizenComplaint updateCitizenComplaint(Integer id, CitizenComplaint updatedComplaint) {
//        CitizenComplaint complaint = getCitizenComplaintById(id);
//        if (complaint != null) {
//            complaint.setCitizen(updatedComplaint.getCitizen());
//            complaint.setIssueCategory(updatedComplaint.getIssueCategory());
//            complaint.setArea(updatedComplaint.getArea());
//            complaint.setDescription(updatedComplaint.getDescription());
//            complaint.setSubmittedAt(updatedComplaint.getSubmittedAt());
//            
//            // ✅ Add this line to update action status
//            complaint.setActionStatus(updatedComplaint.getActionStatus());
//            
//            return citizenComplaintRepository.save(complaint);
//        }
//        return null;
//    }

//    public CitizenComplaint updateCitizenComplaint(Integer id, CitizenComplaint updatedComplaint) {
//        CitizenComplaint complaint = getCitizenComplaintById(id);
//        if (complaint != null) {
//            complaint.setCitizen(updatedComplaint.getCitizen());
//            complaint.setIssueCategory(updatedComplaint.getIssueCategory());
//            complaint.setArea(updatedComplaint.getArea());
//            complaint.setDescription(updatedComplaint.getDescription());
//            complaint.setSubmittedAt(updatedComplaint.getSubmittedAt());
//            return citizenComplaintRepository.save(complaint);
//        }
//        return null;
//    }

    public void deleteCitizenComplaint(Integer id) {
        citizenComplaintRepository.deleteById(id);
    }
}
