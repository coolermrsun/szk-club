package com.szk.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限dto
 * 
 * @author: szk
2023/11/3
 */
@Data
public class AuthPermissionBO implements Serializable {

    private Long id;
    
    private String name;
    
    private Long parentId;
    
    private Integer type;
    
    private String menuUrl;
    
    private Integer status;
    
    private Integer show;
    
    private String icon;
    
    private String permissionKey;
}

