package com.szk.subject.infra.basic.service.impl;

import com.szk.subject.infra.basic.entity.SubjectBrief;
import com.szk.subject.infra.basic.mapper.SubjectBriefMapper;
import com.szk.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 简答题(SubjectBrief)表服务实现类
 *
 * @author makejava
 * @since 2025-02-17 16:01:14
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl implements SubjectBriefService {
    @Resource
    private SubjectBriefMapper subjectBriefMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectBrief queryById(Long id) {
        return this.subjectBriefMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefMapper.insert(subjectBrief);
        return subjectBrief;
    }

    /**
     * 修改数据
     *
     * @param subjectBrief 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectBrief update(SubjectBrief subjectBrief) {
        this.subjectBriefMapper.update(subjectBrief);
        return this.queryById(subjectBrief.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectBriefMapper.deleteById(id) > 0;
    }

    @Override
    public SubjectBrief queryByCondition(SubjectBrief subjectBrief) {
        return this.subjectBriefMapper.queryAllByLimit(subjectBrief);
    }
}
