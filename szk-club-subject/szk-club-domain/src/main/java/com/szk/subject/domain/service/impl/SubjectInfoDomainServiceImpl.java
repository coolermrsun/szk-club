package com.szk.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.szk.subject.common.enums.IsDeletedFlagEnum;
import com.szk.subject.domain.convert.SubjectInfoConverter;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.handler.subject.SubjectTypeHandler;
import com.szk.subject.domain.handler.subject.SubjectTypeHandlerFactory;
import com.szk.subject.domain.service.SubjectInfoDomainService;
import com.szk.subject.infra.basic.entity.SubjectInfo;
import com.szk.subject.infra.basic.entity.SubjectMapping;
import com.szk.subject.infra.basic.service.SubjectInfoService;
import com.szk.subject.infra.basic.service.SubjectLabelService;
import com.szk.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectLabelService subjectLabelService;

    private static final String RANK_KEY = "subject_rank";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
        handler.add(subjectInfoBO);
        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);
//        //同步到es
//        SubjectInfoEs subjectInfoEs = new SubjectInfoEs();
//        subjectInfoEs.setDocId(new IdWorkerUtil(1, 1, 1).nextId());
//        subjectInfoEs.setSubjectId(subjectInfo.getId());
//        subjectInfoEs.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
//        subjectInfoEs.setCreateTime(new Date().getTime());
//        subjectInfoEs.setCreateUser("鸡翅");
//        subjectInfoEs.setSubjectName(subjectInfo.getSubjectName());
//        subjectInfoEs.setSubjectType(subjectInfo.getSubjectType());
//        subjectEsService.insert(subjectInfoEs);
//        //redis放入zadd计入排行榜
//        redisUtil.addScore(RANK_KEY, LoginUtil.getLoginId(), 1);
    }
}
