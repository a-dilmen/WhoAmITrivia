package com.dilmen.repository;

import com.dilmen.repository.entity.GameParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameParticipationRepository extends JpaRepository<GameParticipation,Long> {
    List<GameParticipation> findAllByPlayerId(Long id);
}
