package com.spring.app.TrainSheet.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExerciceMuscu extends Exercice {

    private int nombreSerie ;
    private int masse ;
    private int outils ;
    private int duree;

    public ExerciceMuscu(Long id, String nom, String description, Seance seance, int nombreSerie, int masse, int outils, int duree) {
        super(id, nom, description, seance);
        this.nombreSerie = nombreSerie;
        this.masse = masse;
        this.outils = outils;
        this.duree = duree;
    }
}
