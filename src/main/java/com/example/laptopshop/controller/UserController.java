package com.example.laptopshop.controller;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/admin/user")
    public String getAdminPage(Model model) {
        String test = userService.handleHello();
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createAdminPage(@ModelAttribute("newUser") User user) {
        System.out.println(user);
        return "hello";
    }
    @PatchMapping("/hello/user")
    public String handleHello(){
        String test = userService.handleHello();
        System.out.println(test);
        return "hello";
    }
}
