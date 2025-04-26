package com.example.laptopshop.controller.admin;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

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
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/index";
    }
    @GetMapping("admin/user/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }
    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }
    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createAdminPage(@ModelAttribute("newUser") User user) {
        System.out.println(this.userService.handleSaveUser(user));
        return "redirect:/admin/user";
    }
    @GetMapping("admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }
    @PostMapping("/admin/user/update")
    public String updateUser(@ModelAttribute("user") User user) {
        User user1 = this.userService.getUserById(user.getId());
        if(user1 != null) {
            user1.setAddress(user.getAddress());
            user1.setPhone(user.getPhone());
            user1.setFullName(user.getFullName());
            userService.handleSaveUser(user1);
        }
        System.out.println(user1);
        return "redirect:/admin/user";
    }
    @GetMapping("/admin/user/delete/{id}")
    public String confirmDeleteUser(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("user", new User());
        return "admin/user/delete";
    }
    @PostMapping("/admin/user/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        System.out.println(user);
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
