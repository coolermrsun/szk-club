package com.szk.subject.domain.convert;

import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.infra.basic.entity.SubjectBrief;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-13T15:20:12+0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_432 (Amazon.com Inc.)"
)
public class BriefSubjectConverterImpl implements BriefSubjectConverter {

    @Override
    public SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO) {
        if ( subjectInfoBO == null ) {
            return null;
        }

        SubjectBrief subjectBrief = new SubjectBrief();

        subjectBrief.setId( subjectInfoBO.getId() );
        subjectBrief.setSubjectAnswer( subjectInfoBO.getSubjectAnswer() );

        return subjectBrief;
    }
}
