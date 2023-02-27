package com.dilmen.controller;

import com.dilmen.dto.request.*;
import com.dilmen.dto.response.PlayerResponseDto;
import com.dilmen.exception.ErrorType;
import com.dilmen.exception.WhoAmITriviaException;
import com.dilmen.repository.entity.Player;
import com.dilmen.service.GameParticipationService;
import com.dilmen.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.dilmen.constants.EndPoints.*;

@RestController
@RequestMapping(PLAYER)
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final GameParticipationService gameParticipationService;


    @GetMapping(REGISTER)
    public ResponseEntity<PlayerResponseDto> register(PlayerRegisterRequestDto dto){

        return ResponseEntity.ok(playerService.register(dto));
    }
    @GetMapping(LOGIN)
    public ResponseEntity<PlayerResponseDto> login(PlayerLoginRequestDto dto){
        return ResponseEntity.ok(playerService.login(dto));
    }

    @GetMapping(DELETE)
    public ResponseEntity<Boolean> deleteAccount(PlayerLoginRequestDto dto){
        return ResponseEntity.ok(playerService.delete(dto));
    }

    @GetMapping(GETPOINTS)
    public ResponseEntity<List<Integer>> getMyGames(PlayerLoginRequestDto dto){
        Optional<Player> player = playerService.findOptionalByUsername(dto.getUsername());
        if (player.isPresent()) return ResponseEntity.ok(gameParticipationService.findAllResponse(player.get().getId()));
        throw new WhoAmITriviaException(ErrorType.USER_NOT_FOUND);
    }

    @GetMapping(PLAY)
    public ResponseEntity<Boolean> play(PlayerLoginRequestDto dto){
        Optional<Player> player = playerService.findOptionalByUsernameAndPassword(dto.getUsername(),dto.getPassword());
        if (player.isPresent()) return ResponseEntity.ok(true);
        else throw new WhoAmITriviaException(ErrorType.PLEASE_LOGIN_TO_PLAY);
    }


}
