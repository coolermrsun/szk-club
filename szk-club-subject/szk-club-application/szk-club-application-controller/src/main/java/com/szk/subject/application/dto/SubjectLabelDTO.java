package com.szk.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签dto
 */
@Data
public class SubjectLabelDTO implements Serializable {
    private static final long serialVersionUID = -33222756046140437L;
/**
     * 主键
     */
    private Long id;
    /**
     * 分类的id
     */
    private Long categoryId;
    /**
     * 标签分类
     */
    private String labelName;
/**
     * 排序
     */
    private Integer sortNum;

}

