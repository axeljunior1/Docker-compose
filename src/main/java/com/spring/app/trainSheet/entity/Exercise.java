package com.spring.app.trainSheet.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String description;

    @Enumerated(STRING)
    private DisciplineExercise discipline;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "session_id")
    private Session session;
}
