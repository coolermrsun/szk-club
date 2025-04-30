package com.szk.subject.domain.service;

import com.szk.subject.common.entity.PageResult;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.entity.SubjectLabelBO;
import com.szk.subject.infra.basic.entity.SubjectInfoEs;

import java.util.List;

/**
 * 题目领域服务
 * 
 * @author: ChickenWing
 * @date: 2023/10/3
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

    /**
     * 全文检索
     */
    PageResult<SubjectInfoEs> getSubjectPageBySearch(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> getContributeList();


}

