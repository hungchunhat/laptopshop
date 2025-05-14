package com.example.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminProductController")
@RequestMapping("/admin")
public class ProductController {
    @GetMapping("/product")
    public String getAdminProduct() {
        return "admin/product/index";
    }
}
