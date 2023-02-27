package com.dilmen.service;

import com.dilmen.dto.request.AdminLoginRequestDto;
import com.dilmen.dto.request.AdminRegisterRequestDto;
import com.dilmen.dto.response.AdminLoginResponseDto;
import com.dilmen.exception.ErrorType;
import com.dilmen.exception.WhoAmITriviaException;
import com.dilmen.mapper.IAdminMapper;
import com.dilmen.repository.IAdminRepository;
import com.dilmen.repository.entity.Admin;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService extends ServiceManager<Admin,Long> {

    private final IAdminRepository adminRepository;
    public AdminService(IAdminRepository adminRepository){
        super(adminRepository);
        this.adminRepository = adminRepository;
    }

    public Admin register(AdminRegisterRequestDto dto) {
        Optional<Admin> admin = adminRepository.findOptionalByUsername(dto.getUsername());
        if (admin.isPresent()) throw new WhoAmITriviaException(ErrorType.BAD_REQUEST_ERROR);
        return save(IAdminMapper.INSTANCE.adminFromRegisterRequestDto(dto));
    }

    public AdminLoginResponseDto login(AdminLoginRequestDto dto) {
        Optional<Admin> admin = adminRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        AdminLoginResponseDto loginResponseDto = null;
        if (admin.isPresent()) return loginResponseDto = IAdminMapper.INSTANCE.adminLoginResponseDtoFromAdmin(admin.get());
        throw new WhoAmITriviaException(ErrorType.USER_NOT_FOUND);
    }


}
