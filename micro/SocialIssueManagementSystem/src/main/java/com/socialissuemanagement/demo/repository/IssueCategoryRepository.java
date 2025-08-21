package com.socialissuemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialissuemanagement.demo.entities.IssueCategory;

@Repository
public interface IssueCategoryRepository extends JpaRepository<IssueCategory, Integer> {
}
