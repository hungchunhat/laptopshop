package com.example.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "<h1>Hello World from home</h1>";
    }

    @GetMapping("/user")
    public String userPage() {
        return "<h1>Only user can access this page</h1>";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "<h1>Only admin can access this page</h1>";
    }
}
