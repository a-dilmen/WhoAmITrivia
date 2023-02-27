package com.dilmen.repository;


import com.dilmen.repository.entity.Admin;
import com.dilmen.repository.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findOptionalByUsername(String username);

    Optional<Player> findOptionalByUsernameAndPassword(String username, String password);
}
