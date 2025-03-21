package com.szk.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目标签dto
 */
@Data
public class SubjectLabelBO implements Serializable {
    private static final long serialVersionUID = -33222756046140437L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;
    /**
     * 分类的id
     */
    private Long categoryId;
}

