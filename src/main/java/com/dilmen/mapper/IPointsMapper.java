package com.dilmen.mapper;

import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.dto.request.QuestionCreateRequestDto;
import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.repository.entity.GameParticipation;
import com.dilmen.repository.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IPointsMapper {

    IPointsMapper INSTANCE = Mappers.getMapper(IPointsMapper.class);

    GameParticipation questionFromQuestionCreateRequestDto(final PlayerLoginRequestDto dto);

}
