package com.operatorservice.demo.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operatorservice.demo.entity.ComplaintStatus;

@Repository
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Integer> {
}


