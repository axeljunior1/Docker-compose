package com.spring.app.trainSheet.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String discipline;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}