package com.dilmen.mapper;

import com.dilmen.dto.request.AdminLoginRequestDto;
import com.dilmen.dto.request.AdminRegisterRequestDto;
import com.dilmen.dto.response.AdminLoginResponseDto;
import com.dilmen.repository.entity.Admin;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-27T16:54:02+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class IAdminMapperImpl implements IAdminMapper {

    @Override
    public Admin adminFromRegisterRequestDto(AdminRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admin.AdminBuilder<?, ?> admin = Admin.builder();

        admin.username( dto.getUsername() );
        admin.password( dto.getPassword() );
        admin.email( dto.getEmail() );

        return admin.build();
    }

    @Override
    public Admin adminFromLoginRequestDto(AdminLoginRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admin.AdminBuilder<?, ?> admin = Admin.builder();

        admin.username( dto.getUsername() );
        admin.password( dto.getPassword() );

        return admin.build();
    }

    @Override
    public AdminLoginResponseDto adminLoginResponseDtoFromAdmin(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminLoginResponseDto.AdminLoginResponseDtoBuilder adminLoginResponseDto = AdminLoginResponseDto.builder();

        adminLoginResponseDto.username( admin.getUsername() );

        return adminLoginResponseDto.build();
    }
}
