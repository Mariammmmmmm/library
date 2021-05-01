package com.VKR.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(String name, Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

}
