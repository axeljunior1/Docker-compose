package com.spring.app.TrainSheet.Repository;

import com.spring.app.TrainSheet.Entity.Discipline;
import com.spring.app.TrainSheet.Entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long > {
    void deleteBySeance(Seance s);
}
