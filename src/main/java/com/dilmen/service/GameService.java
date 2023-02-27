package com.dilmen.service;

import com.dilmen.dto.response.QuestionResponseDto;
import com.dilmen.repository.IGameRepository;
import com.dilmen.repository.entity.Game;
import com.dilmen.repository.entity.Question;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService extends ServiceManager<Game,Long> {

    private final IGameRepository gameRepository;
    public GameService(IGameRepository gameRepository){
        super(gameRepository);
        this.gameRepository = gameRepository;
    }

}
