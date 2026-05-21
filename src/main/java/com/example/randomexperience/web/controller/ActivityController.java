package com.example.randomexperience.web.controller;

import com.example.randomexperience.model.Activity;
import com.example.randomexperience.model.User;
import com.example.randomexperience.model.enums.Category;
import com.example.randomexperience.model.enums.LocationType;
import com.example.randomexperience.service.ActivityService;
import com.example.randomexperience.service.FavoriteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recommendations")
public class ActivityController {

    private final ActivityService activityService;
    private final FavoriteService favoriteService;

    public ActivityController(ActivityService activityService,
                              FavoriteService favoriteService) {
        this.activityService = activityService;
        this.favoriteService = favoriteService;
    }

    @GetMapping("/all")
    public String getAllActivities(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        List<Activity> activities = activityService.getAllActivities();

        model.addAttribute("activities", activities);

        model.addAttribute("favoriteIds",
                favoriteService.getUserFavorites(user)
                        .stream()
                        .map(f -> f.getActivity().getId())
                        .toList()
        );

        model.addAttribute("favoriteCounts",
                favoriteService.getFavoriteCounts()
        );

        return "list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("activity", new Activity());
        return "form";
    }

    @PostMapping("/save")
    public String saveActivity(@ModelAttribute Activity activity) {
        activityService.saveActivity(activity);
        return "redirect:/recommendations/all";
    }

    @GetMapping("/category/{category}")
    public String getByCategory(@PathVariable Category category, Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        model.addAttribute("activities",
                activityService.getActivitiesByCategory(category));

        model.addAttribute("favoriteIds",
                favoriteService.getUserFavorites(user)
                        .stream()
                        .map(f -> f.getActivity().getId())
                        .toList()
        );

        model.addAttribute("selectedCategory", category);

        return "list";
    }

    @PostMapping("/recommend")
    public String recommendActivities(
            @RequestParam(required = false) LocationType locationType,
            @RequestParam(required = false) Double maxBudget,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) Category category,
            Model model,
            HttpSession session
    ) {

        User user = (User) session.getAttribute("user");

        List<Activity> activities = activityService.recommendActivities(
                locationType, maxBudget, maxDuration, category
        );

        model.addAttribute("activities", activities);

        model.addAttribute("favoriteIds",
                favoriteService.getUserFavorites(user)
                        .stream()
                        .map(f -> f.getActivity().getId())
                        .toList()
        );

        return "list";
    }

    @GetMapping("/recommended")
    public String recommended(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/home";
        }

        List<Activity> activities =
                favoriteService.getRecommendedForUser(user);

        model.addAttribute("activities", activities);
        model.addAttribute("pageTitle", "Recommended for you");

        return "list";
    }
}