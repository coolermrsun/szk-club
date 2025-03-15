package com.szk.auth.application.convert;

import com.szk.auth.application.dto.AuthPermissionDTO;
import com.szk.auth.domain.entity.AuthPermissionBO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:43:01+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_432 (Amazon.com Inc.)"
)
public class AuthPermissionDTOConverterImpl implements AuthPermissionDTOConverter {

    @Override
    public AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO) {
        if ( authPermissionDTO == null ) {
            return null;
        }

        AuthPermissionBO authPermissionBO = new AuthPermissionBO();

        return authPermissionBO;
    }
}
