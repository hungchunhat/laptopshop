package com.example.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("clientProductController")
@RequestMapping("/client")
public class ProductController {
    @GetMapping("product/{id}")
    public String getProductPage(Model model, @PathVariable long id){

        return "client/product/show";
    }
}
