package com.VKR.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/forchildren")
    public String forchildren(Model model) {
        model.addAttribute("title", "Детская литература");
        return "forchildren";
    }

    @GetMapping("/forschoolchildren")
    public String forschoolchildren(Model model) {
        model.addAttribute("title", "Для школьников");
        return "forschoolchildren";
    }

    @GetMapping("/forstudents")
    public String forstudents(Model model) {
        model.addAttribute("title", "Для студентов");
        return "forstudents";
    }

    @GetMapping("/fiction")
    public String fiction(Model model) {
        model.addAttribute("title", "Художественная литература");
        return "fiction";
    }

    @GetMapping("/scientific")
    public String scientific(Model model) {
        model.addAttribute("title", "Научная литература");
        return "scientific";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "profile";
    }


}
