package com.example.randomexperience.repository;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.Favorite;
import com.example.randomexperience.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUser(User user);

    Optional<Favorite> findByUserAndActivity(User user, Activity activity);

    boolean existsByUserAndActivity(User user, Activity activity);

    long countByActivity(Activity activity);
}