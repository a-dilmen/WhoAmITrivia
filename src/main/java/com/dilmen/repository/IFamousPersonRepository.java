package com.dilmen.repository;

import com.dilmen.repository.entity.FamousPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFamousPersonRepository extends JpaRepository<FamousPerson,Long> {
}
