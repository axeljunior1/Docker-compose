package com.spring.app.TrainSheet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String discp ;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "seance_id")
    private Seance seance;



}