package com.szk.subject.domain.handler.subject;

import com.szk.subject.common.enums.IsDeletedFlagEnum;
import com.szk.subject.common.enums.SubjectInfoTypeEnum;
import com.szk.subject.domain.convert.RadioSubjectConverter;
import com.szk.subject.domain.entity.SubjectAnswerBO;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.domain.entity.SubjectOptionBO;
import com.szk.subject.infra.basic.entity.SubjectRadio;
import com.szk.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 单选题目的策略类
 *
 * @author: ChickenWing
 * @date: 2023/10/5
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断 subjectInfoBO 是否为 null
        if (subjectInfoBO == null) {
            throw new IllegalArgumentException("SubjectInfoBO cannot be null");
        }
        List<SubjectAnswerBO> optionList = subjectInfoBO.getOptionList();
        // 判断 optionList 是否为空
        if (optionList == null || optionList.isEmpty()) {
            throw new IllegalArgumentException("Option list cannot be null or empty");
        }
        // 单选题目的插入
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        for (SubjectAnswerBO option : optionList) {
            // 如果选项为空，跳过该项
            if (option == null) {
                continue; // 跳过 null 选项
            }
            // 校验选项的有效性
            if (option.getOptionType() == null || option.getOptionContent() == null || option.getOptionContent().trim().isEmpty()) {
                continue; // 跳过无效选项
            }
            // 将 SubjectAnswerBO 转换为 SubjectRadio 实体对象
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);
            // 对 subjectRadio 进行非空检查
            if (subjectRadio == null) {
                continue; // 如果转换结果为空，跳过当前选项
            }
            // 设置 SubjectRadio 的相关属性
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            // 添加到集合
            subjectRadioList.add(subjectRadio);
        }
        // 如果有有效的 SubjectRadio 对象，则批量插入
        if (!subjectRadioList.isEmpty()) {
            subjectRadioService.batchInsert(subjectRadioList);
        } else {
            throw new IllegalArgumentException("No valid subject radio found for insertion");
        }
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
