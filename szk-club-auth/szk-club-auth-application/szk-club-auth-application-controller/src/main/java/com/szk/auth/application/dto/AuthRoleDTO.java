package com.szk.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色dto
 *
 * @author: szk
 * @date: 2023/11/2
 */
@Data
public class AuthRoleDTO implements Serializable {

    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

