package com.dilmen.mapper;

import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.dto.request.PlayerRegisterRequestDto;
import com.dilmen.dto.response.PlayerResponseDto;
import com.dilmen.repository.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IPlayerMapper {

    IPlayerMapper INSTANCE = Mappers.getMapper(IPlayerMapper.class);

    Player playerFromLoginRequestDto(final PlayerLoginRequestDto dto);

    Player playerFromRegisterRequestDto(final PlayerRegisterRequestDto dto);

    PlayerResponseDto playerResponseDtoFromPlayerLoginRequestDto(final PlayerLoginRequestDto dto);
    PlayerResponseDto playerResponseDtoFromPlayerRegisterRequestDto(final PlayerRegisterRequestDto dto);
}
