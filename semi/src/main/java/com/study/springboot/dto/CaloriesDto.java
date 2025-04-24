package com.study.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesDto {
    private String mealTime;
    private int totalCalories;

    public CaloriesDto(String mealTime, Number totalCalories) {
        this.mealTime = mealTime;
        this.totalCalories = totalCalories != null ? totalCalories.intValue() : 0;
    }
}
