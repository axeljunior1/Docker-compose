package com.spring.app.trainSheet.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ExerciseCardio extends Exercise {
    private int weight;
    private int seriesNumber;
    private int duration;
}
