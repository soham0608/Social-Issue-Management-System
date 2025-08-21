package com.operatorservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operatorservice.demo.entity.CitizenComplaint;

@Repository
public interface CitizenComplaintRepository extends JpaRepository<CitizenComplaint, Integer> {
}
