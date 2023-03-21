package com.pratice.second.dto;

import com.pratice.second.entity.totalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class totalDto {
    private Long userId;
    private int time;
    private double calorie;
}
