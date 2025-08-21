//package com.socialissuemanagement.demo.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.socialissuemanagement.demo.entities.Citizen;
//import com.socialissuemanagement.demo.entities.CitizenComplaint;
//import com.socialissuemanagement.demo.entities.ComplaintStatus;
//import com.socialissuemanagement.demo.entities.ZoneOperator;
//import com.socialissuemanagement.demo.repository.CitizenComplaintRepository;
//import com.socialissuemanagement.demo.repository.ComplaintStatusRepository;
//import com.socialissuemanagement.demo.repository.ZoneOperatorRepository;
//
//import dao.ComplaintStatusRequestDto;
//import dao.ComplaintStatusResponseDto;
//
//@Service
//public class ComplaintStatusService {
//
//    @Autowired
//    private ComplaintStatusRepository complaintStatusRepository;
//
//    @Autowired
//    private CitizenComplaintRepository citizenComplaintRepository;
//
//    @Autowired
//    private ZoneOperatorRepository zoneOperatorRepository;
//
//    public ComplaintStatus createComplaintStatus(ComplaintStatus complaintStatus) {
//        // ✅ Correct extraction of complaintId
//        Integer complaintId = complaintStatus.getComplaint() != null ? complaintStatus.getComplaint().getComplaintId() : null;
//        if (complaintId == null) {
//            throw new RuntimeException("Complaint ID is missing in the request payload.");
//        }
//
//        // Fetch and attach managed CitizenComplaint
//        CitizenComplaint managedComplaint = citizenComplaintRepository.findById(complaintId)
//            .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + complaintId));
//        complaintStatus.setComplaint(managedComplaint);
//
//        // Fetch and attach managed ZoneOperator if present
//        if (complaintStatus.getHandledBy() != null) {
//            Integer operatorId = complaintStatus.getHandledBy().getOperatorId();
//            ZoneOperator managedOperator = zoneOperatorRepository.findById(operatorId)
//                .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + operatorId));
//            complaintStatus.setHandledBy(managedOperator);
//        }
//
//        // Set updated_at
//        complaintStatus.setUpdatedAt(LocalDateTime.now());
//
//        // Upsert logic if necessary:
//        if (complaintStatusRepository.existsById(complaintId)) {
//            ComplaintStatus existing = complaintStatusRepository.findById(complaintId).get();
//            existing.setStatus(complaintStatus.getStatus());
//            existing.setUpdatedAt(complaintStatus.getUpdatedAt());
//            existing.setHandledBy(complaintStatus.getHandledBy());
//            existing.setNote(complaintStatus.getNote());
//            return complaintStatusRepository.save(existing);
//        } else {
//            return complaintStatusRepository.save(complaintStatus);
//        }
//    }
//
//
//    public List<ComplaintStatus> getAllComplaintStatuses() {
//        return complaintStatusRepository.findAll();
//    }
//
//    public ComplaintStatus getComplaintStatusById(Integer id) {
//        return complaintStatusRepository.findById(id).orElse(null);
//    }
//    
//    public ComplaintStatusResponseDto updateComplaintStatus(Integer id, ComplaintStatus updatedStatus) {
//        ComplaintStatus status = getComplaintStatusById(id);
//        if (status != null) {
//            status.setStatus(updatedStatus.getStatus());
//            status.setUpdatedAt(LocalDateTime.now());
//
//            if (updatedStatus.getHandledBy() != null) {
//                Integer operatorId = updatedStatus.getHandledBy().getOperatorId();
//                ZoneOperator managedOperator = zoneOperatorRepository.findById(operatorId)
//                    .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + operatorId));
//                status.setHandledBy(managedOperator);
//            } else {
//                status.setHandledBy(null);
//            }
//
//            status.setNote(updatedStatus.getNote());
//            complaintStatusRepository.save(status);
//
//         
//            CitizenComplaint complaint = status.getComplaint();
//            Citizen citizen = complaint.getCitizen();
//
//            return new ComplaintStatusResponseDto(
//                citizen.getCid(),
//                citizen.getFname(),
//                citizen.getLname(),
//                complaint.getIssueCategory().getDescription(),
//                complaint.getArea().getAreaName(),
//                status.getStatus(),
//                complaint.getSubmittedAt()
//            );
//        }
//        return null;
//    }
//
//
//
//    
//
//    public ComplaintStatus saveComplaintStatus(ComplaintStatusRequestDto requestDto) {
//        CitizenComplaint complaint = citizenComplaintRepository.findById(requestDto.getComplaintId())
//            .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + requestDto.getComplaintId()));
//
//        ComplaintStatus status = new ComplaintStatus();
//        status.setComplaint(complaint);
//        status.setComplaintId(complaint.getComplaintId());
//        status.setStatus(requestDto.getStatus());
////        status.setNote(requestDto.getNote());
//        status.setUpdatedAt(LocalDateTime.now());
//
//        if (requestDto.getHandledById() != null) {
//            ZoneOperator operator = zoneOperatorRepository.findById(requestDto.getHandledById())
//                .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + requestDto.getHandledById()));
//            status.setHandledBy(operator);
//        }
//
//        return complaintStatusRepository.save(status);
//    }
//
//    
////    public ComplaintStatus saveComplaintStatus(ComplaintStatusRequestDto requestDto) {
////        // Get and validate complaint
////        CitizenComplaint complaint = citizenComplaintRepository.findById(requestDto.getComplaintId())
////            .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + requestDto.getComplaintId()));
////
////        // Create new ComplaintStatus
////        ComplaintStatus complaintStatus = new ComplaintStatus();
////        complaintStatus.setComplaint(complaint);
////        complaintStatus.setStatus(requestDto.getStatus());
//////        complaintStatus.setNote(requestDto.getNote());
////        complaintStatus.setUpdatedAt(LocalDateTime.now());
////
////        // Optional: Set handledBy if provided
////        if (requestDto.getHandledBy() != null) {
////            ZoneOperator operator = zoneOperatorRepository.findById(requestDto.getHandledBy())
////                .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + requestDto.getHandledBy()));
////            complaintStatus.setHandledBy(operator);
////        }
////
////        return complaintStatusRepository.save(complaintStatus);
////    }
//    
////    public ComplaintStatusResponseDto getComplaintStatusResponseById(Integer complaintId) {
////        ComplaintStatus status = complaintStatusRepository.findById(complaintId).orElse(null);
////        
////        if (status != null) {
////            CitizenComplaint complaint = status.getComplaint();
////            return new ComplaintStatusResponseDto(
////                complaint.getDescription(),
////                complaint.getActionStatus(),
////                status.getNote(),
////                complaint.getSubmittedAt()
////            );
////        }
////
////        return null;
////    }
//
//
//    public void deleteComplaintStatus(Integer id) {
//        complaintStatusRepository.deleteById(id);
//    }
//    
//    
//
//    public List<ComplaintStatusResponseDto> getComplaintStatusDetails() {
//        List<ComplaintStatus> statusList = complaintStatusRepository.findAll();
//
//        return statusList.stream()
//            .map(status -> {
//                CitizenComplaint complaint = status.getComplaint();
//                Citizen citizen = complaint.getCitizen();
//
//                return new ComplaintStatusResponseDto(
//                	    citizen.getCid(),
//                	    citizen.getFname(),
//                	    citizen.getLname(),
//                	    complaint.getIssueCategory().getDescription(), 
//                	    complaint.getArea().getAreaName(),              // assumes Area has getAreaName()
//                	    status.getStatus(),
//                	    complaint.getSubmittedAt()
//                	);
//
//            })
//            .collect(Collectors.toList());
//    }
//
//
//
//
////    public List<ComplaintStatusResponseDto> getComplaintStatusDetails() {
////        List<ComplaintStatus> statusList = complaintStatusRepository.findAll();
////
////        return statusList.stream()
////            .map(status -> {
////                CitizenComplaint complaint = status.getComplaint();
////                return new ComplaintStatusResponseDto(
////                    complaint.getDescription(),
////                    complaint.getActionStatus(),
////                    
////                    complaint.getSubmittedAt()
////                );
////            })
////            .collect(Collectors.toList());
////    }
//
//}

package com.socialissuemanagement.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialissuemanagement.demo.entities.CitizenComplaint;
import com.socialissuemanagement.demo.entities.ComplaintStatus;
import com.socialissuemanagement.demo.entities.ZoneOperator;
import com.socialissuemanagement.demo.repository.CitizenComplaintRepository;
import com.socialissuemanagement.demo.repository.ComplaintStatusRepository;
import com.socialissuemanagement.demo.repository.ZoneOperatorRepository;

import dao.ComplaintStatusRequestDto;
import dao.ComplaintStatusResponseDto;

@Service
public class ComplaintStatusService {

    @Autowired
    private ComplaintStatusRepository complaintStatusRepository;

    @Autowired
    private CitizenComplaintRepository citizenComplaintRepository;

    @Autowired
    private ZoneOperatorRepository zoneOperatorRepository;

    public ComplaintStatus saveComplaintStatus(ComplaintStatusRequestDto requestDto) {
        CitizenComplaint complaint = citizenComplaintRepository.findById(requestDto.getComplaintId())
            .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + requestDto.getComplaintId()));

        ComplaintStatus status = new ComplaintStatus();
        status.setComplaint(complaint);
        status.setComplaintId(complaint.getComplaintId());
        status.setStatus(requestDto.getStatus());
        status.setNote(requestDto.getNote());
        status.setUpdatedAt(LocalDateTime.now());

        if (requestDto.getHandledById() != null) {
            ZoneOperator operator = zoneOperatorRepository.findById(requestDto.getHandledById())
                .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + requestDto.getHandledById()));
            status.setHandledBy(operator);
        }

        return complaintStatusRepository.save(status);
    }
    
    public ComplaintStatus createComplaintStatus(ComplaintStatus complaintStatus) {
      // ✅ Correct extraction of complaintId
      Integer complaintId = complaintStatus.getComplaint() != null ? complaintStatus.getComplaint().getComplaintId() : null;
      if (complaintId == null) {
          throw new RuntimeException("Complaint ID is missing in the request payload.");
      }

      // Fetch and attach managed CitizenComplaint
      CitizenComplaint managedComplaint = citizenComplaintRepository.findById(complaintId)
          .orElseThrow(() -> new RuntimeException("Complaint not found with ID: " + complaintId));
      complaintStatus.setComplaint(managedComplaint);

      // Fetch and attach managed ZoneOperator if present
      if (complaintStatus.getHandledBy() != null) {
          Integer operatorId = complaintStatus.getHandledBy().getOperatorId();
          ZoneOperator managedOperator = zoneOperatorRepository.findById(operatorId)
              .orElseThrow(() -> new RuntimeException("Zone Operator not found with ID: " + operatorId));
          complaintStatus.setHandledBy(managedOperator);
      }

      // Set updated_at
      complaintStatus.setUpdatedAt(LocalDateTime.now());

      // Upsert logic if necessary:
      if (complaintStatusRepository.existsById(complaintId)) {
          ComplaintStatus existing = complaintStatusRepository.findById(complaintId).get();
          existing.setStatus(complaintStatus.getStatus());
          existing.setUpdatedAt(complaintStatus.getUpdatedAt());
          existing.setHandledBy(complaintStatus.getHandledBy());
          existing.setNote(complaintStatus.getNote());
          return complaintStatusRepository.save(existing);
      } else {
          return complaintStatusRepository.save(complaintStatus);
      }
  }


    public List<ComplaintStatus> getAllComplaintStatuses() {
        return complaintStatusRepository.findAll();
    }

    public ComplaintStatus getComplaintStatusById(Integer id) {
        return complaintStatusRepository.findById(id).orElse(null);
    }

    public ComplaintStatusResponseDto updateComplaintStatus(Integer id, ComplaintStatus updatedStatus) {
        ComplaintStatus status = complaintStatusRepository.findById(id).orElse(null);
        if (status != null) {
            status.setStatus(updatedStatus.getStatus());
            status.setNote(updatedStatus.getNote());
            status.setUpdatedAt(LocalDateTime.now());

            if (updatedStatus.getHandledBy() != null) {
                ZoneOperator operator = zoneOperatorRepository.findById(updatedStatus.getHandledBy().getOperatorId())
                        .orElseThrow(() -> new RuntimeException("Operator not found"));
                status.setHandledBy(operator);
            }

            ComplaintStatus saved = complaintStatusRepository.save(status);

            CitizenComplaint complaint = saved.getComplaint();
            return new ComplaintStatusResponseDto(
                    complaint.getCitizen().getCid(),
                    complaint.getCitizen().getFname(),
                    complaint.getCitizen().getLname(),
                    complaint.getIssueCategory().getDescription(),
                    complaint.getArea().getAreaName(),
                    saved.getStatus(),
                    complaint.getSubmittedAt()
            );
        }
        return null;
    }

    public void deleteComplaintStatus(Integer id) {
        complaintStatusRepository.deleteById(id);
    }

    public List<ComplaintStatusResponseDto> getComplaintStatusDetails() {
        return complaintStatusRepository.findAll().stream().map(status -> {
            CitizenComplaint complaint = status.getComplaint();
            return new ComplaintStatusResponseDto(
                complaint.getCitizen().getCid(),
                complaint.getCitizen().getFname(),
                complaint.getCitizen().getLname(),
                complaint.getIssueCategory().getDescription(),
                complaint.getArea().getAreaName(),
                status.getStatus(),
                complaint.getSubmittedAt()
            );
        }).collect(Collectors.toList());
    }
}

