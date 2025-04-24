package com.study.springboot.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.study.springboot.dto.CaloriesDto;
import com.study.springboot.dto.DailyCaloriesDto;
import com.study.springboot.dto.FoodLogDto;
import com.study.springboot.dto.FoodLogRequest;
import com.study.springboot.entity.FoodLog;
import com.study.springboot.repository.FoodLogRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/food-logs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FoodLogController {

    private final FoodLogRepository foodLogRepository;

    // 저장 (bulk)
    @PostMapping("/bulk")
    public ResponseEntity<?> saveBulk(@RequestBody List<FoodLogRequest> requestList) {
        for (FoodLogRequest req : requestList) {
            if (req.getUserId() == null || req.getUserId().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("userId가 없습니다.");
            }
            if (req.getFoodId() == null) {
                return ResponseEntity.badRequest().body("foodId가 없습니다.");
            }
            if (req.getMealTime() == null || req.getMealTime().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("mealTime이 없습니다.");
            }
            if (req.getLogDate() == null) {
                return ResponseEntity.badRequest().body("logDate가 없습니다.");
            }
        }

        List<FoodLog> foodLogs = requestList.stream()
            .map(req -> FoodLog.builder()
                .userId(req.getUserId())
                .foodId(req.getFoodId())
                .quantity(req.getQuantity())
                .totalCalories(req.getTotalCalories())
                .mealTime(req.getMealTime())
                .logDate(req.getLogDate().toLocalDate().atStartOfDay()) // 00시 고정
                .build()
            ).collect(Collectors.toList());

        foodLogRepository.saveAll(foodLogs);
        return ResponseEntity.ok("저장 완료!");
    }

    // 날짜별 기록 조회 (Entity 직접 반환)
    @GetMapping("/by-date")
    public ResponseEntity<List<FoodLog>> getFoodLogsByDate(
        @RequestParam("userId") String userId,
        @RequestParam("date") String date
    ) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        List<FoodLog> logs = foodLogRepository.findByUserIdAndLogDateBetween(userId, start, end);
        return ResponseEntity.ok(logs);
    }

    // 날짜별 기록 조회 (DTO 반환, 음식 이름 포함)
    @GetMapping("/{userId}")
    public ResponseEntity<List<FoodLogDto>> getFoodLogsByUserAndDate(
            @PathVariable("userId") String userId,
            @RequestParam("date") String date) {

        LocalDate targetDate = LocalDate.parse(date);
        LocalDateTime startOfDay = targetDate.atStartOfDay();
        LocalDateTime endOfDay = targetDate.atTime(LocalTime.MAX);

        List<FoodLog> logs = foodLogRepository.findWithFoodByUserIdAndLogDateBetween(userId, startOfDay, endOfDay);

        List<FoodLogDto> result = logs.stream().map(log -> FoodLogDto.builder()
                .userId(log.getUserId())
                .foodId(log.getFoodId())
                .quantity(log.getQuantity())
                .totalCalories(log.getTotalCalories())
                .mealTime(log.getMealTime())
                .logDate(log.getLogDate())
                .build()
        ).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    // 식사별(아침/점심/저녁) 칼로리 합계 조회 API
    @GetMapping("/meal-calories")
    public ResponseEntity<?> getMealCalories(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "date") String date) {

        LocalDate targetDate = LocalDate.parse(date);
        LocalDateTime start = targetDate.atStartOfDay();
        LocalDateTime end = targetDate.atTime(LocalTime.MAX);

        List<CaloriesDto> results = foodLogRepository.findMealCaloriesByUserIdAndDate(userId, start, end);

        Map<String, Integer> response = results.stream()
                .collect(Collectors.toMap(CaloriesDto::getMealTime, CaloriesDto::getTotalCalories));

        return ResponseEntity.ok(response);
    }

    // 날짜별 총 칼로리 (캘린더용) - 인터페이스 기반 DTO 사용
    @GetMapping("/total-calories")
    public ResponseEntity<?> getTotalCaloriesByDate(
            @RequestParam(name = "userId") String userId) {

        List<DailyCaloriesDto> results = foodLogRepository.findTotalCaloriesGroupedByDate(userId);

        return ResponseEntity.ok(results);
    }
}
