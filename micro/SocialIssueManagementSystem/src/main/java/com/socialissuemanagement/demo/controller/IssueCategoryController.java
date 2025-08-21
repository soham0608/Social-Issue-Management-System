package com.socialissuemanagement.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialissuemanagement.demo.entities.IssueCategory;
import com.socialissuemanagement.demo.service.IssueCategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/issues")
public class IssueCategoryController {

    @Autowired
    private IssueCategoryService issueCategoryService;

    @PostMapping
    public IssueCategory createIssueCategory(@RequestBody IssueCategory issueCategory) {
        return issueCategoryService.createIssueCategory(issueCategory);
    }

    @GetMapping
    public List<IssueCategory> getAllIssueCategories() {
        return issueCategoryService.getAllIssueCategories();
    }

    @GetMapping("/{id}")
    public IssueCategory getIssueCategoryById(@PathVariable Integer id) {
        return issueCategoryService.getIssueCategoryById(id);
    }

    @PutMapping("/{id}")
    public IssueCategory updateIssueCategory(@PathVariable Integer id, @RequestBody IssueCategory issueCategory) {
        return issueCategoryService.updateIssueCategory(id, issueCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteIssueCategory(@PathVariable Integer id) {
        issueCategoryService.deleteIssueCategory(id);
    }
}
