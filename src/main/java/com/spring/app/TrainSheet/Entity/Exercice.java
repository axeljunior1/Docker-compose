package com.spring.app.TrainSheet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String description;

    @Enumerated(EnumType.STRING)
    private DisciplineExercice discipline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "seance_id")
    private Seance seance;


    public Exercice(Long id, String nom, String description, Seance seance) {
    }
}
