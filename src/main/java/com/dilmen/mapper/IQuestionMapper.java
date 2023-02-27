package com.dilmen.mapper;

import com.dilmen.dto.request.QuestionCreateRequestDto;
import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.repository.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IQuestionMapper {

    IQuestionMapper INSTANCE = Mappers.getMapper(IQuestionMapper.class);

    Question questionFromQuestionCreateRequestDto(final QuestionCreateRequestDto dto);
    QuestionResponseDto questionResponseDtofromQuestion(final Question question);

}
