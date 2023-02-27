package com.dilmen.controller;

import com.dilmen.dto.request.AdminLoginRequestDto;
import com.dilmen.dto.request.AdminRegisterRequestDto;
import com.dilmen.dto.request.QuestionCreateRequestDto;
import com.dilmen.dto.response.AdminLoginResponseDto;
import com.dilmen.dto.response.AdminRegisterResponseDto;
import com.dilmen.exception.ErrorType;
import com.dilmen.exception.WhoAmITriviaException;
import com.dilmen.repository.entity.Admin;
import com.dilmen.repository.entity.Question;
import com.dilmen.service.AdminService;
import com.dilmen.service.PlayerService;
import com.dilmen.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.dilmen.constants.EndPoints.*;

@RestController
@RequestMapping(ADMIN)
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final QuestionService questionService;

    private final PlayerService playerService;

    @GetMapping(REGISTER)
    public ResponseEntity<Boolean> register(AdminRegisterRequestDto dto){
        adminService.register(dto);
        return ResponseEntity.ok(true);
    }
    @GetMapping(LOGIN)
    public ResponseEntity<AdminLoginResponseDto> login(AdminLoginRequestDto dto){
        AdminLoginResponseDto admin = adminService.login(dto);
        return ResponseEntity.ok(admin);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<Question>> findAllQuestions(){
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping(BANPLAYER)
    public ResponseEntity<Boolean> deletePlayer(String username){
        return ResponseEntity.ok(playerService.delete(username));
    }

    @GetMapping(SAVE)
    public ResponseEntity<Boolean> createQuestion(QuestionCreateRequestDto dto){
        return ResponseEntity.ok(questionService.createQuestionRequest(dto));
    }

}
