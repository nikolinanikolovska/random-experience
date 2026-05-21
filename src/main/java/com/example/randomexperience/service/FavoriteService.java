package com.example.randomexperience.service;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.Favorite;
import com.example.randomexperience.model.User;

import java.util.List;
import java.util.Map;

public interface FavoriteService {

    List<Favorite> getUserFavorites(User user);

    List<Long> getFavoriteActivityIds(User user);

    void toggleFavorite(Long activityId, User user);

    void removeFavorite(Long activityId, User user);

    long countByActivity(Activity activity);

    Map<Long, Long> getFavoriteCounts();

    List<Activity> getRecommendedForUser(User user);
}