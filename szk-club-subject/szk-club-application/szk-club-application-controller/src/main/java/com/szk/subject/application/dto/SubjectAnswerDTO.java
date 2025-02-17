package com.szk.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目答案DTO
 *
 * @author makejava
 * @since 2025-02-17 15:57:10
 */
@Data
public class SubjectAnswerDTO implements Serializable {
    private static final long serialVersionUID = 802124656573658600L;
    /**
     * 答案选项标识
     */
    private Integer optionType;

    /**
     * 答案
     */
    private String optionContent;

    /**
     * 是否正确
     */
    private Integer isCorrect;
}

