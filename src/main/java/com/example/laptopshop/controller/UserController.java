package com.example.laptopshop.controller;

import com.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = userService.handleHello();
        model.addAttribute("hungdeptrai", test);
        model.addAttribute("hungdeptrai2", "Hello from UserController");
        return "hello";
    }
    @RequestMapping("/admin/user")
    public String getAdminPage(Model model) {
        return "admin/user/create";
    }
}
