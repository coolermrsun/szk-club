package com.szk.auth.domain.service;

import com.szk.auth.domain.entity.AuthRoleBO;

/**
 * 角色领域service
 * 
 * @author: szk
2023/11/1
 */
public interface AuthRoleDomainService {

    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);

}
