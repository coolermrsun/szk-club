package com.szk.subject.domain.handler.subject;

import com.szk.subject.common.enums.IsDeletedFlagEnum;
import com.szk.subject.common.enums.SubjectInfoTypeEnum;
import com.szk.subject.domain.convert.BriefSubjectConverter;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.entity.SubjectOptionBO;
import com.szk.subject.infra.basic.entity.SubjectBrief;
import com.szk.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 简答题目的策略类
 * 
 * @author: szk

 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 检查 subjectInfoBO 是否为 null
        if (subjectInfoBO == null) {
            throw new IllegalArgumentException("SubjectInfoBO cannot be null");
        }
        // 获取 subjectId 并校验
        Long subjectId = subjectInfoBO.getId();
        if (subjectId == null || subjectId <= 0) {
            throw new IllegalArgumentException("Subject ID cannot be null or less than or equal to zero");
        }
        // 将 SubjectInfoBO 转换为 SubjectBrief 实体对象
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        // 校验转换后的 subjectBrief 是否为空
        if (subjectBrief == null) {
            throw new IllegalArgumentException("Failed to convert SubjectInfoBO to SubjectBrief");
        }
        // 设置相关属性
        subjectBrief.setSubjectId(subjectId.intValue());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        // 调用 insert 方法插入数据
        subjectBriefService.insert(subjectBrief);
    }


    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
