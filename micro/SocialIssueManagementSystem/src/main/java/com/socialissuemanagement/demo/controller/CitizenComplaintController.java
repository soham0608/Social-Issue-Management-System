package com.socialissuemanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialissuemanagement.demo.entities.Citizen;
import com.socialissuemanagement.demo.entities.CitizenComplaint;
import com.socialissuemanagement.demo.entities.IssueCategory;
import com.socialissuemanagement.demo.entities.User;
import com.socialissuemanagement.demo.service.AreaService;
import com.socialissuemanagement.demo.service.CitizenComplaintService;
import com.socialissuemanagement.demo.service.CitizenService;
import com.socialissuemanagement.demo.service.IssueCategoryService;
import com.socialissuemanagement.demo.service.UserService;

import dao.ComplaintData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/complaints")
public class CitizenComplaintController {

    @Autowired
    private CitizenComplaintService citizenComplaintService;
    
    @Autowired
    CitizenService citizenService;
    
    @Autowired
    UserService userService;
    
    @Autowired
   IssueCategoryService issueCategoryService;
    
    

    @PostMapping
    public CitizenComplaint createCitizenComplaint(@RequestBody CitizenComplaint complaint) {
        return citizenComplaintService.createCitizenComplaint(complaint);
    }

    @GetMapping
    public List<CitizenComplaint> getAllCitizenComplaints() {
        return citizenComplaintService.getAllCitizenComplaints();
    }

//    @GetMapping("/{id}")
//    public CitizenComplaint getCitizenComplaintById(@PathVariable Integer id) {
//        return citizenComplaintService.getCitizenComplaintById(id);
//    }
    
    @GetMapping("/{id}")
    public CitizenComplaint getCitizenComplaintById(@PathVariable("id") Integer id) {
        return citizenComplaintService.getCitizenComplaintById(id);
    }


//    @PutMapping("/{id}")
//    public CitizenComplaint updateCitizenComplaint(@PathVariable("id") Integer id, @RequestBody CitizenComplaint complaint) {
//        return citizenComplaintService.updateCitizenComplaint(id, complaint);
//    }
    
    @PutMapping("/{id}")
    public CitizenComplaint updateCitizenComplaint(@PathVariable("id") Integer id, @RequestBody CitizenComplaint complaint) {
        return citizenComplaintService.updateCitizenComplaint(id, complaint);
    }

    
    @PatchMapping("/{id}/status")
    public CitizenComplaint updateActionStatus(@PathVariable("id") Integer id, @RequestBody Map<String, Integer> payload) {
        CitizenComplaint complaint = citizenComplaintService.getCitizenComplaintById(id);
        if (complaint != null && payload.containsKey("actionStatus")) {
            complaint.setActionStatus(payload.get("actionStatus"));
            return citizenComplaintService.createCitizenComplaint(complaint); // save() again
        }
        return null;
    }



    @DeleteMapping("/{id}")
    public void deleteCitizenComplaint(@PathVariable Integer id) {
        citizenComplaintService.deleteCitizenComplaint(id);
    }
    
    @PostMapping("/register")
    public CitizenComplaint registerComplaint( @RequestBody ComplaintData cd) {
    	User u = userService.getUserById(cd.getUserid());
    	System.out.println(u);
    	
    	Citizen c =citizenService.getCitizen(u); 
    	System.out.println(c);
    	IssueCategory ic = issueCategoryService.getIssueCategoryById(cd.getCatid());
    	LocalDateTime cdate = LocalDateTime.now();
    	
    	CitizenComplaint cc = new CitizenComplaint();
    	cc.setCitizen(c);
    	cc.setDescription(cd.getIssdesc());
    	cc.setArea(c.getArea());
    	cc.setIssueCategory(ic);
    	cc.setSubmittedAt(null);
    	cc.setSubmittedAt(cdate);
    	
    	return citizenComplaintService.createCitizenComplaint(cc);
    	
    	
    	
    }
}
