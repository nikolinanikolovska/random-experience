package com.example.randomexperience.service;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;

import java.util.List;

public interface ActivityService {

    List<Activity> recommendActivities(LocationType locationType,
                                       Double maxBudget,
                                       Integer maxDuration,
                                       Category category);

    List<Activity> getAllActivities();

    List<Activity> getActivitiesByCategory(Category category);

    Activity getById(Long id);

    Activity saveActivity(Activity activity);

    void deleteActivity(Long id);
}