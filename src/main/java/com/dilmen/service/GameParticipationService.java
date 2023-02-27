package com.dilmen.service;

import com.dilmen.dto.PointsResponseDto;
import com.dilmen.dto.request.PlayerLoginRequestDto;
import com.dilmen.repository.IGameParticipationRepository;
import com.dilmen.repository.entity.GameParticipation;
import com.dilmen.repository.entity.Player;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameParticipationService extends ServiceManager<GameParticipation,Long> {

    private final IGameParticipationRepository gameParticipationRepository;

    public GameParticipationService(IGameParticipationRepository gameParticipationRepository){
        super(gameParticipationRepository);
        this.gameParticipationRepository = gameParticipationRepository;
    }

    public List<Integer> findAllResponse(Long id) {
        List<GameParticipation> gameParticipations =  gameParticipationRepository.findAllByPlayerId(id);
        List<Integer> points = gameParticipations.stream().map(x-> x.getPoints()).toList();
        return points;
    }
}
