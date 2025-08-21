package com.example.SecondService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SecondService.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
