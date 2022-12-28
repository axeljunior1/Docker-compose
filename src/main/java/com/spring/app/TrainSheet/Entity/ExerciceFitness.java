package com.spring.app.TrainSheet.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ExerciceFitness extends Exercice {


    private int nbre_km;
    private int vitesse_moyenne;
    private int duree;

    public ExerciceFitness(Long id, String nom, String description, Seance seance, int nbre_km, int vitesse_moyenne, int duree) {
        super(id, nom, description, seance);
        this.nbre_km = nbre_km;
        this.vitesse_moyenne = vitesse_moyenne;
        this.duree = duree;
    }
}
