package com.szk.subject.infra.basic.mapper;

import com.szk.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * 题目分类(SubjectCategory)表数据库访问层
 *
 * @author makejava
 * @since 2025-02-17 11:29:55
 */
public interface SubjectCategoryMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 统计总行数
     *
     * @param subjectCategory 查询条件
     * @return 总行数
     */
    long count(SubjectCategory subjectCategory);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 影响行数
     */
    int insert(SubjectCategory subjectCategory);

    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 影响行数
     */
    int update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    Integer querySubjectCount(Long id);
}

