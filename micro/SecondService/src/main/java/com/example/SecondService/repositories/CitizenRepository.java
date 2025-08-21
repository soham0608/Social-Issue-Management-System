package com.example.SecondService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SecondService.entities.Citizen;
import com.example.SecondService.entities.User;



@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
	
	@Query("select c from Citizen c where c.user = ?1")
	public Citizen getCitizen(User user);
}
