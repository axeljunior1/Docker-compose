package com.spring.app.trainSheet.repository;

import com.spring.app.trainSheet.entity.Discipline;
import com.spring.app.trainSheet.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    void deleteBySession(Session session);
}
