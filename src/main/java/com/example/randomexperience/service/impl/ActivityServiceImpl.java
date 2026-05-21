package com.example.randomexperience.service.impl;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.ScoredActivity;
import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;
import com.example.randomexperience.repository.ActivityRepository;
import com.example.randomexperience.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> recommendActivities(LocationType locationType,
                                              Double maxBudget,
                                              Integer maxDuration,
                                              Category category) {

        return activityRepository.findAll().stream()
                .filter(a -> locationType == null || a.getLocationType() == locationType)
                .filter(a -> category == null || a.getCategory() == category)
                .filter(a -> maxBudget == null || a.getCost() <= maxBudget)
                .filter(a -> maxDuration == null || a.getDurationMinutes() <= maxDuration)
                .map(activity -> {

                    int score = 0;

                    if (locationType != null && activity.getLocationType() == locationType) {
                        score += 5;
                    }

                    if (category != null && activity.getCategory() == category) {
                        score += 4;
                    }

                    if (maxBudget != null && activity.getCost() <= maxBudget) {
                        score += 3;
                    }

                    if (maxDuration != null && activity.getDurationMinutes() <= maxDuration) {
                        score += 2;
                    }

                    score += (int) (Math.random() * 2);

                    return new ScoredActivity(activity, score);
                })
                .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore()))
                .map(ScoredActivity::getActivity)
                .limit(10)
                .toList();
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }


    @Override
    public Activity getById(Long id) {
        Optional<Activity> activity = activityRepository.findById(id);
        return activity.orElseThrow();
    }

    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    @Override
    public List<Activity> getActivitiesByCategory(Category category) {
        return activityRepository.findByCategory(category);
    }
}