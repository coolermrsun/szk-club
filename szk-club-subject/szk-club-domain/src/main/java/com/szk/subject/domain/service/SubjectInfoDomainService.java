package com.szk.subject.domain.service;

import com.szk.subject.common.entity.PageResult;
import com.szk.subject.domain.entity.SubjectInfoBO;

/**
 * 题目领域服务
 * 
 * @author: szk
2023/10/3
 */
public interface SubjectInfoDomainService {

    /**
     * 新增题目
     */
    void add(SubjectInfoBO subjectInfoBO);
    /**
     * 分页查询
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);
    /**
     * 查询题目信息
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}

