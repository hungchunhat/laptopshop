package com.example.laptopshop.controller.client;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.domain.dto.RegisterDTO;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomePageController {

    private final ProductService productService;
    private final UserService userService;
    public HomePageController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }
    @GetMapping("/")
    public String getHomePage(Model model)
    {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products",products);
        return "client/homepage/index";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("newUser", new RegisterDTO());
        return "client/auth/register";
    }
    @PostMapping("/register")
    public String postRegisterPage(Model model, @ModelAttribute("newUser") RegisterDTO registerDTO){
        User user = userService.registerDTOtoUser(registerDTO);
        userService.handleCreateUser(user, null);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        return "client/auth/login";
    }
}
