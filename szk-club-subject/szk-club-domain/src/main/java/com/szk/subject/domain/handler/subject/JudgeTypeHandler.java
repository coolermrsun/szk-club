package com.szk.subject.domain.handler.subject;

import com.szk.subject.common.enums.IsDeletedFlagEnum;
import com.szk.subject.common.enums.SubjectInfoTypeEnum;
import com.szk.subject.domain.convert.JudgeSubjectConverter;
import com.szk.subject.domain.entity.SubjectAnswerBO;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.entity.SubjectOptionBO;
import com.szk.subject.infra.basic.entity.SubjectJudge;
import com.szk.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;

/**
 * 判断题目的策略类
 * 
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断 subjectInfoBO 是否为 null
        if (subjectInfoBO == null) {
            throw new IllegalArgumentException("SubjectInfoBO cannot be null");
        }
        // 获取选项列表并判断是否为空
        List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
        if (optionList == null || optionList.isEmpty()) {
            throw new IllegalArgumentException("Option list cannot be null or empty");
        }
        // 获取第一个选项并判断其是否为 null
        SubjectAnswerBO subjectAnswerBO = optionList.get(0);
        if (subjectAnswerBO == null) {
            throw new IllegalArgumentException("SubjectAnswerBO cannot be null");
        }
        // 创建 SubjectJudge 实体并设置相关字段
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        // 判断 IsCorrect 是否有效
        Integer isCorrect = subjectAnswerBO.getIsCorrect();
        if (isCorrect == null) {
            throw new IllegalArgumentException("IsCorrect cannot be null");
        }
        subjectJudge.setIsCorrect(isCorrect);
        // 设置删除标志位
        subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        // 调用 insert 方法插入数据
        subjectJudgeService.insert(subjectJudge);
    }


    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = JudgeSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
