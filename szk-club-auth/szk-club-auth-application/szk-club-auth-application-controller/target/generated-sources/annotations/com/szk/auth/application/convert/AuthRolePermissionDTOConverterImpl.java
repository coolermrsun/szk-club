package com.szk.auth.application.convert;

import com.szk.auth.application.dto.AuthRolePermissionDTO;
import com.szk.auth.domain.entity.AuthRolePermissionBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:43:01+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_432 (Amazon.com Inc.)"
)
public class AuthRolePermissionDTOConverterImpl implements AuthRolePermissionDTOConverter {

    @Override
    public AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO authRolePermissionDTO) {
        if ( authRolePermissionDTO == null ) {
            return null;
        }

        AuthRolePermissionBO authRolePermissionBO = new AuthRolePermissionBO();

        return authRolePermissionBO;
    }
}
