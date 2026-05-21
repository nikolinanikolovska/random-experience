package com.example.randomexperience.service.impl;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.Favorite;
import com.example.randomexperience.model.User;
import com.example.randomexperience.repository.ActivityRepository;
import com.example.randomexperience.repository.FavoriteRepository;
import com.example.randomexperience.service.FavoriteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ActivityRepository activityRepository;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                               ActivityRepository activityRepository) {
        this.favoriteRepository = favoriteRepository;
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Favorite> getUserFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }

    @Override
    public List<Long> getFavoriteActivityIds(User user) {
        return favoriteRepository.findByUser(user)
                .stream()
                .map(f -> f.getActivity().getId())
                .toList();
    }

    @Override
    public void toggleFavorite(Long activityId, User user) {

        Activity activity = activityRepository.findById(activityId)
                .orElseThrow();

        favoriteRepository.findByUserAndActivity(user, activity)
                .ifPresentOrElse(
                        favoriteRepository::delete,
                        () -> favoriteRepository.save(new Favorite(user, activity))
                );
    }

    @Override
    public void removeFavorite(Long activityId, User user) {

        Activity activity = activityRepository.findById(activityId)
                .orElseThrow();

        favoriteRepository.findByUserAndActivity(user, activity)
                .ifPresent(favoriteRepository::delete);
    }

    @Override
    public long countByActivity(Activity activity) {
        return favoriteRepository.countByActivity(activity);
    }

    @Override
    public Map<Long, Long> getFavoriteCounts() {
        return favoriteRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        f -> f.getActivity().getId(),
                        Collectors.counting()
                ));
    }

    @Override
    public List<Activity> getRecommendedForUser(User user) {

        return favoriteRepository.findByUser(user)
                .stream()
                .map(Favorite::getActivity)
                .toList();
    }
}