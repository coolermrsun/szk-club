package com.szk.subject.application.convert;

import com.szk.subject.application.dto.SubjectCategoryDTO;
import com.szk.subject.domain.entity.SubjectCategoryBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-19T15:54:44+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_432 (Amazon.com Inc.)"
)
public class SubjectCategoryDTOConverterImpl implements SubjectCategoryDTOConverter {

    @Override
    public List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryBOList) {
        if ( subjectCategoryBOList == null ) {
            return null;
        }

        List<SubjectCategoryDTO> list = new ArrayList<SubjectCategoryDTO>( subjectCategoryBOList.size() );
        for ( SubjectCategoryBO subjectCategoryBO : subjectCategoryBOList ) {
            list.add( subjectCategoryBOToSubjectCategoryDTO( subjectCategoryBO ) );
        }

        return list;
    }

    @Override
    public SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO) {
        if ( subjectCategoryDTO == null ) {
            return null;
        }

        SubjectCategoryBO subjectCategoryBO = new SubjectCategoryBO();

        subjectCategoryBO.setId( subjectCategoryDTO.getId() );
        subjectCategoryBO.setCategory_name( subjectCategoryDTO.getCategory_name() );
        subjectCategoryBO.setCategory_type( subjectCategoryDTO.getCategory_type() );
        subjectCategoryBO.setImage_url( subjectCategoryDTO.getImage_url() );
        subjectCategoryBO.setParent_id( subjectCategoryDTO.getParent_id() );

        return subjectCategoryBO;
    }

    protected SubjectCategoryDTO subjectCategoryBOToSubjectCategoryDTO(SubjectCategoryBO subjectCategoryBO) {
        if ( subjectCategoryBO == null ) {
            return null;
        }

        SubjectCategoryDTO subjectCategoryDTO = new SubjectCategoryDTO();

        subjectCategoryDTO.setId( subjectCategoryBO.getId() );
        subjectCategoryDTO.setCategory_name( subjectCategoryBO.getCategory_name() );
        subjectCategoryDTO.setCategory_type( subjectCategoryBO.getCategory_type() );
        subjectCategoryDTO.setImage_url( subjectCategoryBO.getImage_url() );
        subjectCategoryDTO.setParent_id( subjectCategoryBO.getParent_id() );

        return subjectCategoryDTO;
    }
}
