package com.codebay.goldeneye.controllers;

import com.codebay.goldeneye.models.User;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {  
    @GetMapping("/")
    public String index() {
        // return "redirect:/register";
        return "index";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @PostMapping("/register")
    public String registerPost(User user, Model model){
        
        user.generateEmail();

        model.addAttribute("user", user);

        return "showUser";
    }
    
}