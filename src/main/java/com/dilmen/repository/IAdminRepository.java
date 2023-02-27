package com.dilmen.repository;


import com.dilmen.repository.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long> {
    Optional<Admin> findOptionalByUsernameAndPassword(String username, String password);

    Optional<Admin> findOptionalByUsername(String username);
}
