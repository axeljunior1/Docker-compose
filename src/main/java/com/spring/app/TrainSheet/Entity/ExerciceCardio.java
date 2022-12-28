package com.spring.app.TrainSheet.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExerciceCardio extends Exercice{
    private int masse;
    private int nombreSerie;
    private int duree;

    public ExerciceCardio(Long id, String nom, String description, DisciplineExercice discipline, Seance seance, int masse, int nombreSerie, int duree) {
        super(id, nom, description, discipline, seance);
        this.masse = masse;
        this.nombreSerie = nombreSerie;
        this.duree = duree;
    }
}
