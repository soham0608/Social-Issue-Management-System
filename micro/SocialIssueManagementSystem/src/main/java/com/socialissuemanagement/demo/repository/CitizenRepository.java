package com.socialissuemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.Citizen;
import com.socialissuemanagement.demo.entities.User;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
	
	@Query("select c from Citizen c where c.user = ?1")
	public Citizen getCitizen(User user);
}
