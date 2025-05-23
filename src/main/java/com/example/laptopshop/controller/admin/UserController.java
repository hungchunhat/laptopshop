package com.example.laptopshop.controller.admin;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.service.UploadService;
import com.example.laptopshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
    public String createAdminPage(@ModelAttribute("newUser") @Valid User user,
                                  BindingResult bindingResult, @RequestParam("file") MultipartFile file) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        errors.forEach(fieldError -> System.out.println(">>>>>> " + fieldError.getField() + " " + fieldError.getDefaultMessage()));
        if (bindingResult.hasErrors()) {
            return "admin/user/create";
        }
        String avatar = uploadService.handleSaveUpload(file, "avatar");
        userService.handleCreateUser(user, avatar);
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String updateUser(Model model, @ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @RequestParam MultipartFile file) {
        boolean errors = userService.hasErrors(bindingResult);
        if (errors) {
            model.addAttribute("user",user);
            return "admin/user/update";
        }
        String fileName = null;
        if (file != null && !file.isEmpty()) {
            fileName = uploadService.handleSaveUpload(file, "avatar");
        }
        userService.handleUpdateUser(user, fileName);
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
