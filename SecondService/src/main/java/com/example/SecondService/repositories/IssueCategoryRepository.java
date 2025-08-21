package com.example.SecondService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SecondService.entities.IssueCategory;



@Repository
public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Integer> {
}
