package com.operatorservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.operatorservice.demo.entity.ZoneOperator;

@Repository
public interface ZoneOperatorRepository extends JpaRepository<ZoneOperator, Integer> {
}
