package com.spring.app.trainSheet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FitnessExercise extends Exercise {
    private int distance;
    private int averageSpeed;
    private int duration;
}
