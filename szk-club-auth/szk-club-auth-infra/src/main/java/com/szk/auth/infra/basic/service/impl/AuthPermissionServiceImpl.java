package com.szk.auth.infra.basic.service.impl;

import com.szk.auth.infra.basic.entity.AuthPermission;
import com.szk.auth.infra.basic.mapper.AuthPermissionMapper;
import com.szk.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthPermission)表服务实现类
 *
 * @author makejava
 * @since 2025-02-23 16:08:47
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionMapper authPermissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthPermission queryById(Long id) {
        return this.authPermissionMapper.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(AuthPermission authPermission) {
        return this.authPermissionMapper.insert(authPermission);
    }


    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public int update(AuthPermission authPermission) {
        return this.authPermissionMapper.update(authPermission);
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authPermissionMapper.deleteById(id) > 0;
    }

    @Override
    public List<AuthPermission> queryByRoleList(List<Long> roleIdList) {
        return this.authPermissionMapper.queryByRoleList(roleIdList);
    }


}
