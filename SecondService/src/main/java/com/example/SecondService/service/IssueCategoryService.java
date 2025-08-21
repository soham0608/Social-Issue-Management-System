package com.example.SecondService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SecondService.entities.IssueCategory;
import com.example.SecondService.repositories.IssueCategoryRepository;

import java.util.List;

@Service
public class IssueCategoryService {

    @Autowired
    private IssueCategoryRepository issueCategoryRepository;

    public IssueCategory createIssueCategory(IssueCategory issueCategory) {
        return issueCategoryRepository.save(issueCategory);
    }

    public List<IssueCategory> getAllIssueCategories() {
        return issueCategoryRepository.findAll();
    }

    public IssueCategory getIssueCategoryById(Integer id) {
        return issueCategoryRepository.findById(id).orElse(null);
    }

    public IssueCategory updateIssueCategory(Integer id, IssueCategory updatedCategory) {
        IssueCategory category = getIssueCategoryById(id);
        if (category != null) {
            category.setDescription(updatedCategory.getDescription());
            return issueCategoryRepository.save(category);
        }
        return null;
    }

    public void deleteIssueCategory(Integer id) {
        issueCategoryRepository.deleteById(id);
    }
}
