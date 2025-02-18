package com.szk.subject.domain.handler.subject;

import com.szk.subject.common.enums.IsDeletedFlagEnum;
import com.szk.subject.common.enums.SubjectInfoTypeEnum;
import com.szk.subject.domain.convert.MultipleSubjectConverter;
import com.szk.subject.domain.entity.SubjectAnswerBO;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.entity.SubjectOptionBO;
import com.szk.subject.infra.basic.entity.SubjectMultiple;
import com.szk.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 多选题目的策略类
 * 
 * @author: szk
 * @date: 2023/10/5
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
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
        // 多选题目的插入
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        for (SubjectAnswerBO option : optionList) {
            // 如果选项为空，跳过该项
            if (option == null) {
                continue;
            }
            // 将 SubjectAnswerBO 转换为 SubjectMultiple 实体对象
            SubjectMultiple subjectMultiple = MultipleSubjectConverter.INSTANCE.convertBoToEntity(option);

            // 对 subjectMultiple 进行非空检查
            if (subjectMultiple == null) {
                continue; // 跳过转换失败的选项
            }
            // 设置相关属性
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            // 将有效的 SubjectMultiple 添加到列表
            subjectMultipleList.add(subjectMultiple);
        }
        // 如果有有效的 SubjectMultiple 对象，则批量插入
        if (!subjectMultipleList.isEmpty()) {
            subjectMultipleService.batchInsert(subjectMultipleList);
        } else {
            throw new IllegalArgumentException("No valid subject multiple found for insertion");
        }
    }


    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = MultipleSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
