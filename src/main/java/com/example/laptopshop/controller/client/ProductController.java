package com.example.laptopshop.controller.client;

import com.example.laptopshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("clientProductController")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("product/{id}")
    public String getProductPage(Model model, @PathVariable long id){
        model.addAttribute("product", productService.getProductById(id).get());
        return "client/product/show";
    }
}
