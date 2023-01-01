package com.spring.app.trainSheet.repository;

import com.spring.app.trainSheet.entity.Exercise;
import com.spring.app.trainSheet.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    void deleteBySession(Session session);
}
