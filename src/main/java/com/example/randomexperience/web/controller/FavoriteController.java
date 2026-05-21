package com.example.randomexperience.web.controller;

import com.example.randomexperience.model.User;
import com.example.randomexperience.service.FavoriteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public String getFavorites(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        model.addAttribute("favorites", favoriteService.getUserFavorites(user));

        return "favorites";
    }

    @GetMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id, HttpSession session) {

        User user = (User) session.getAttribute("user");

        favoriteService.toggleFavorite(id, user);

        return "redirect:/recommendations/all";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id, HttpSession session) {

        User user = (User) session.getAttribute("user");

        favoriteService.removeFavorite(id, user);

        return "redirect:/favorites";
    }


}