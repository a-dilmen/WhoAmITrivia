package com.dilmen.service;

import com.dilmen.dto.request.AdminLoginRequestDto;
import com.dilmen.dto.request.AdminRegisterRequestDto;
import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.dto.request.PlayerRegisterRequestDto;
import com.dilmen.dto.response.AdminLoginResponseDto;
import com.dilmen.dto.response.PlayerResponseDto;
import com.dilmen.exception.ErrorType;
import com.dilmen.exception.WhoAmITriviaException;
import com.dilmen.mapper.IAdminMapper;
import com.dilmen.mapper.IPlayerMapper;
import com.dilmen.repository.IPlayerRepository;
import com.dilmen.repository.entity.Admin;
import com.dilmen.repository.entity.Player;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService extends ServiceManager<Player,Long> {

    private final IPlayerRepository playerRepository;
    public PlayerService(IPlayerRepository playerRepository){
        super(playerRepository);
        this.playerRepository = playerRepository;
    }

    public Boolean delete(String username) {
        Optional<Player> player = playerRepository.findOptionalByUsername(username);
        if (player.isPresent()) return true;
        throw new WhoAmITriviaException(ErrorType.USER_NOT_FOUND);
    }

    public PlayerResponseDto register(PlayerRegisterRequestDto dto) {
        Optional<Player> player = playerRepository.findOptionalByUsername(dto.getUsername());
        if (player.isPresent()) throw new WhoAmITriviaException(ErrorType.BAD_REQUEST_ERROR);
        save(IPlayerMapper.INSTANCE.playerFromRegisterRequestDto(dto));
        return IPlayerMapper.INSTANCE.playerResponseDtoFromPlayerRegisterRequestDto(dto);
    }

    public PlayerResponseDto login(PlayerLoginRequestDto dto) {
        Optional<Player> player = playerRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (player.isPresent()) return IPlayerMapper.INSTANCE.playerResponseDtoFromPlayerLoginRequestDto(dto);
        throw new WhoAmITriviaException(ErrorType.BAD_REQUEST_ERROR);
    }

    public Boolean delete(PlayerLoginRequestDto dto) {
        Optional<Player> player = playerRepository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (player.isPresent()) return true;
        playerRepository.delete(player.get());
        throw new WhoAmITriviaException(ErrorType.USER_NOT_FOUND);
    }


    public Optional<Player> findOptionalByUsername(String username) {
        return playerRepository.findOptionalByUsername(username);
    }

    public Optional<Player> findOptionalByUsernameAndPassword(String username, String password) {
        return playerRepository.findOptionalByUsernameAndPassword(username,password);
    }
}
