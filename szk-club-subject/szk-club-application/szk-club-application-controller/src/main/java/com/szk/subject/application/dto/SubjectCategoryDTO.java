package com.szk.subject.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-02-12 14:26:50
 */
@Data
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = 281213603287698155L;

    private Long id;

    /**
     * 分类名称
     */
    private String category_name;

    /**
     * 分类类型
     */
    private Integer category_type;

    /**
     * 图标连接
     */
    private String image_url;

    /**
     * 父级id
     */
    private Long parent_id;
}
