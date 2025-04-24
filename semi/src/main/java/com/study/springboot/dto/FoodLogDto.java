package com.study.springboot.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodLogDto {
    private String userId;
    private Long foodId;
    private int quantity;
    private int totalCalories;
    private String mealTime;
    private LocalDateTime logDate;
    private String foodName;

    public FoodLogDto(Long foodId, String mealTime, String foodName, int totalCalories) {
        this.foodId = foodId;
        this.mealTime = mealTime;
        this.foodName = foodName;
        this.totalCalories = totalCalories;
    }
}
