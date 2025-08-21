//package com.socialissuemanagement.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.socialissuemanagement.demo.entities.CitizenComplaint;
//import com.socialissuemanagement.demo.entities.ComplaintStatus;
//import com.socialissuemanagement.demo.service.ComplaintStatusService;
//
//import dao.ComplaintStatusRequestDto;
//import dao.ComplaintStatusResponseDto;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/api/statuses")
//public class ComplaintStatusController {
//
//    @Autowired
//    private ComplaintStatusService complaintStatusService;
//    
//    @GetMapping
//    public List<ComplaintStatusResponseDto> getAllComplaintStatusDetails() {
//        return complaintStatusService.getComplaintStatusDetails();
//    }
//
//    
//    @GetMapping("/{id}")
//    public ResponseEntity<ComplaintStatus> getComplaintStatusById(@PathVariable("id") Integer id) {
//        ComplaintStatus dto = complaintStatusService.getComplaintStatusById(id);
//        if (dto != null) {
//            return ResponseEntity.ok(dto);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//   
//
//
////    @PostMapping("/api/statuses")
////    public ResponseEntity<ComplaintStatusResponseDto> createComplaintStatus(@RequestBody dao.ComplaintStatusRequestDto requestDto) {
////        ComplaintStatus status = complaintStatusService.saveComplaintStatus(requestDto);
////
////        CitizenComplaint complaint = status.getComplaint();
////
////        ComplaintStatusResponseDto response = new ComplaintStatusResponseDto();
////        response.setDescription(complaint.getDescription());
////        response.setActionStatus(complaint.getActionStatus());
////        response.setNote(status.getNote());
////        response.setSubmittedAt(complaint.getSubmittedAt());
////
////        return ResponseEntity.ok(response);
////    }
//    
//    @PostMapping
//    public ResponseEntity<ComplaintStatus> createComplaintStatus(@RequestBody ComplaintStatusRequestDto requestDto) {
//        ComplaintStatus status = complaintStatusService.saveComplaintStatus(requestDto);
//        return ResponseEntity.ok(status);
//    }
//
//
//
//
//    
//    @PutMapping("/{id}")
//    public ComplaintStatusResponseDto updateComplaintStatus(@PathVariable("id") Integer id, @RequestBody ComplaintStatus status) {
//        return complaintStatusService.updateComplaintStatus(id, status);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void deleteComplaintStatus(@PathVariable Integer id) {
//        complaintStatusService.deleteComplaintStatus(id);
//    }
//}

package com.socialissuemanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.socialissuemanagement.demo.entities.ComplaintStatus;
import com.socialissuemanagement.demo.service.ComplaintStatusService;

import dao.ComplaintStatusRequestDto;
import dao.ComplaintStatusResponseDto;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/statuses")
public class ComplaintStatusController {

    @Autowired
    private ComplaintStatusService complaintStatusService;

    @PostMapping
    public ResponseEntity<ComplaintStatus> createComplaintStatus(@RequestBody ComplaintStatusRequestDto requestDto) {
        ComplaintStatus status = complaintStatusService.saveComplaintStatus(requestDto);
        return ResponseEntity.ok(status);
    }

    @GetMapping
    public List<ComplaintStatusResponseDto> getAllComplaintStatuses() {
        return complaintStatusService.getComplaintStatusDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintStatus> getStatusById(@PathVariable Integer id) {
        ComplaintStatus status = complaintStatusService.getComplaintStatusById(id);
        return status != null ? ResponseEntity.ok(status) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplaintStatusResponseDto> updateStatus(@PathVariable Integer id, @RequestBody ComplaintStatus updatedStatus) {
        ComplaintStatusResponseDto responseDto = complaintStatusService.updateComplaintStatus(id, updatedStatus);
        return responseDto != null ? ResponseEntity.ok(responseDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        complaintStatusService.deleteComplaintStatus(id);
        return ResponseEntity.ok().build();
    }
}

