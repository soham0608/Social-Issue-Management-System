package com.socialissuemanagement.demo.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.ComplaintStatus;

@Repository
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Integer> {
}
//public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Integer> {
//
//    // Optional: If complaint_id is not the primary key in ComplaintStatus
//    Optional<ComplaintStatus> findById(Integer complaintId);
//}

