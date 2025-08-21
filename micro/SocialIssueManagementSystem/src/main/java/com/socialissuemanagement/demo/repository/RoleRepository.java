package com.socialissuemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
