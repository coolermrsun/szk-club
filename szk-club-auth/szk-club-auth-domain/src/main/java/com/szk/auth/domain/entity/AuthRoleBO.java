package com.szk.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色bo
 *
 * @author: szk
2023/11/2
 */
@Data
public class AuthRoleBO implements Serializable {

    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

