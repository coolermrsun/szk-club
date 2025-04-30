package com.szk.subject.domain.convert;

import com.szk.subject.domain.entity.SubjectAnswerBO;
import com.szk.subject.domain.entity.SubjectInfoBO;
import com.szk.subject.infra.basic.entity.SubjectBrief;
import com.szk.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BriefSubjectConverter {

    BriefSubjectConverter INSTANCE = Mappers.getMapper(BriefSubjectConverter.class);

    SubjectBrief convertBoToEntity(SubjectInfoBO subjectInfoBO);

}
