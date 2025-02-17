package com.szk.subject.infra.basic.service.impl;

import com.szk.subject.infra.basic.entity.SubjectJudge;
import com.szk.subject.infra.basic.mapper.SubjectJudgeMapper;
import com.szk.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 判断题(SubjectJudge)表服务实现类
 *
 * @author makejava
 * @since 2025-02-17 16:09:13
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl implements SubjectJudgeService {
    @Resource
    private SubjectJudgeMapper subjectJudgeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectJudge queryById(Long id) {
        return this.subjectJudgeMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge insert(SubjectJudge subjectJudge) {
        this.subjectJudgeMapper.insert(subjectJudge);
        return subjectJudge;
    }

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectJudge update(SubjectJudge subjectJudge) {
        this.subjectJudgeMapper.update(subjectJudge);
        return this.queryById(subjectJudge.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectJudgeMapper.deleteById(id) > 0;
    }

    @Override
    public List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge) {
        return this.subjectJudgeMapper.queryAllByLimit(subjectJudge);
    }
}
