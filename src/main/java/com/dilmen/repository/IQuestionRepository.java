package com.dilmen.repository;

import com.dilmen.repository.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(nativeQuery=true, value="SELECT *  FROM question ORDER BY random() LIMIT 1")
    Question getRandomQuestion();
}
