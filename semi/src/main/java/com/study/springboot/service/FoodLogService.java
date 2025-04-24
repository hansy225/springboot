package com.study.springboot.service;

import com.study.springboot.dto.DailyCaloriesDto;
import com.study.springboot.repository.FoodLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodLogService {

    @Autowired
    private FoodLogRepository foodLogRepository;

    public List<DailyCaloriesDto> getDailyCaloriesByUser(String userId) {
        List<DailyCaloriesDto> result = foodLogRepository.findTotalCaloriesGroupedByDate(userId);
        if (result == null || result.isEmpty()) {
            System.out.println("유효한 userId가 없습니다.");
            return new ArrayList<>();
        }
        return result;
    }
    
    public List<DailyCaloriesDto> getTotalCaloriesGroupedByDate(String userId) {
        return foodLogRepository.findTotalCaloriesGroupedByDate(userId);
    }
}
