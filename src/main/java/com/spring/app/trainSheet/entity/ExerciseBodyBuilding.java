package com.spring.app.trainSheet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExerciseBodyBuilding extends Exercise {
    private int seriesNumber;
    private int weight;
    private int tools;
    private int duration;
}
