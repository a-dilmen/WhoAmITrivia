package com.dilmen.mapper;

import com.dilmen.dto.request.AdminLoginRequestDto;
import com.dilmen.dto.request.AdminRegisterRequestDto;
import com.dilmen.dto.request.PlayerRegisterRequestDto;
import com.dilmen.dto.response.AdminLoginResponseDto;
import com.dilmen.repository.entity.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAdminMapper {

    IAdminMapper INSTANCE = Mappers.getMapper(IAdminMapper.class);

    Admin adminFromRegisterRequestDto(final AdminRegisterRequestDto dto);
    Admin adminFromLoginRequestDto(final AdminLoginRequestDto dto);

    AdminLoginResponseDto adminLoginResponseDtoFromAdmin(final Admin admin);

//    Admin playerFromRegisterRequestDto(final PlayerRegisterRequestDto dto);
}
