package com.example.laptopshop.controller.admin;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UploadService;
import com.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;

    UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
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
    public String createAdminPage(@ModelAttribute("newUser") User user,
                                  @RequestParam("file") MultipartFile file) {
        String avatar = uploadService.handleSaveUpload(file,"avatar");
        String hashPassword = userService.encryptPassword(user.getPassword());
        user.setPassword(hashPassword);
        user.setAvatar(avatar);
        user.setRole(userService.getRoleByName(user.getRole().getName()));
        userService.handleSaveUser(user);
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
        if (user1 != null) {
            user1.setAddress(user.getAddress());
            user1.setPhone(user.getPhone());
            user1.setFullName(user.getFullName());
            user1.setRole(userService.getRoleByName(user.getRole().getName()));
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
