package com.szk.subject.application.controller;

import com.szk.subject.infra.basic.entity.SubjectCategory;
import com.szk.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 刷题Controller
 */
@RestController
public class SubjectController {
    @Resource
    private SubjectCategoryService subjectCategoryService;

    @GetMapping("/test")
    public String test()
    {
        SubjectCategory subjectCategory = subjectCategoryService.queryById(1L);
        return subjectCategory.getCategoryName();
    }
}
