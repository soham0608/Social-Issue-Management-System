package com.socialissuemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.CitizenComplaint;

@Repository
public interface CitizenComplaintRepository extends JpaRepository<CitizenComplaint, Integer> {
}
