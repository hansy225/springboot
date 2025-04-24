package com.study.springboot.repository;

import com.study.springboot.dto.CaloriesDto;
import com.study.springboot.dto.DailyCaloriesDto;
import com.study.springboot.entity.FoodLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {

    @Query(value = """
        SELECT TO_CHAR(log_date, 'YYYY-MM-DD') AS logDate,
               SUM(total_calories) AS totalCalories
        FROM food_logs
        WHERE user_id = :userId
        GROUP BY TO_CHAR(log_date, 'YYYY-MM-DD')
        ORDER BY TO_CHAR(log_date, 'YYYY-MM-DD')
    """, nativeQuery = true)
    List<DailyCaloriesDto> findTotalCaloriesGroupedByDate(@Param("userId") String userId);

    List<FoodLog> findByUserIdAndLogDateBetween(String userId, LocalDateTime start, LocalDateTime end);

    @Query("SELECT f FROM FoodLog f JOIN FETCH f.food " +
           "WHERE f.userId = :userId AND f.logDate BETWEEN :start AND :end")
    List<FoodLog> findWithFoodByUserIdAndLogDateBetween(
            @Param("userId") String userId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);

    @Query("SELECT new com.study.springboot.dto.CaloriesDto(f.mealTime, SUM(f.totalCalories)) " +
           "FROM FoodLog f " +
           "WHERE f.userId = :userId AND f.logDate BETWEEN :start AND :end " +
           "GROUP BY f.mealTime")
    List<CaloriesDto> findMealCaloriesByUserIdAndDate(
            @Param("userId") String userId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);
}
