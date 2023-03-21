package com.pratice.second.dto;

import com.pratice.second.entity.exerciseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class exerciseDto {
    private int exerciseId;
    private String name;
    private double calorie;
    private String category;

    public exerciseEntity toExerciseEntity() {
        return new exerciseEntity(exerciseId, name, calorie, category);
    }
}