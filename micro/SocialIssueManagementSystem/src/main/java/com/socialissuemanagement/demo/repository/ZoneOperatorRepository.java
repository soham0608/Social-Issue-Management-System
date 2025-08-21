package com.socialissuemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.ZoneOperator;

@Repository
public interface ZoneOperatorRepository extends JpaRepository<ZoneOperator, Integer> {
}
