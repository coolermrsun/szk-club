package com.szk.auth.application.convert;

import com.szk.auth.application.dto.AuthPermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.szk.auth.domain.entity.AuthPermissionBO;

/**
 * 权限dto转换器
 * 
 * @author: szk
2023/10/8
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);

}
