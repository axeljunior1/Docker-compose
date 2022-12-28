package com.spring.app.TrainSheet.Repository;

import com.spring.app.TrainSheet.Entity.Discipline;
import com.spring.app.TrainSheet.Entity.Exercice;
import com.spring.app.TrainSheet.Entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercice, Long > {
    void deleteBySeance(Seance seance);
}
