package com.example.randomexperience.config;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;
import com.example.randomexperience.repository.ActivityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final ActivityRepository activityRepository;

    public DataInitializer(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @PostConstruct
    public void init() {

        activityRepository.save(new Activity(
                "Cinema Night",
                "Watch a movie in cinema",
                10.0,
                120,
                LocationType.INDOOR,
                Category.ENTERTAINMENT
        ));

        activityRepository.save(new Activity(
                "Hiking Trip",
                "Outdoor mountain hiking",
                0.0,
                180,
                LocationType.OUTDOOR,
                Category.SPORT
        ));

        activityRepository.save(new Activity(
                "Coffee Relax",
                "Relax in a coffee shop",
                5.0,
                60,
                LocationType.INDOOR,
                Category.RELAX
        ));
    }
}