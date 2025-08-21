package com.socialissuemanagement.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
