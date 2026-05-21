package com.example.randomexperience.repository;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByLocationType(LocationType locationType);

    List<Activity> findByCategory(Category category);

    List<Activity> findByCostLessThanEqual(Double cost);

    List<Activity> findByDurationMinutesLessThanEqual(Integer durationMinutes);
}