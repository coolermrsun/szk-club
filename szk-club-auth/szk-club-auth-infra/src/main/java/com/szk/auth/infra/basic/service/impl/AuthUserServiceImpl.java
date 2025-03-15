package com.szk.auth.infra.basic.service.impl;

import com.szk.auth.infra.basic.entity.AuthUser;
import com.szk.auth.infra.basic.mapper.AuthUserMapper;
import com.szk.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2025-02-23 12:44:07
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserMapper authUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthUser queryById(Long id) {
        return this.authUserMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthUser authUser) {
        return this.authUserMapper.insert(authUser);
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(AuthUser authUser) {
        return  this.authUserMapper.update(authUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserMapper.deleteById(id) > 0;
    }

    @Override
    public List<AuthUser> queryByCondition(AuthUser authUser) {
        return this.authUserMapper.queryAllByLimit(authUser);
    }

    @Override
    public Integer updateByUserName(AuthUser authUser) {
        return this.authUserMapper.updateByUserName(authUser);
    }

    @Override
    public List<AuthUser> listUserInfoByIds(List<String> userNameList) {
        return authUserMapper.listUserInfoByIds(userNameList);
    }
}
