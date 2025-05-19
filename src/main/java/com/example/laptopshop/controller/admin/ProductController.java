package com.example.laptopshop.controller.admin;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("adminProductController")
@RequestMapping("/admin")
public class ProductController {
    public ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/product")
    public String getAdminProduct(Model model) {
        List<Product> products = productService.getProduct();
        model.addAttribute("products",products);
        return "admin/product/index";
    }
    @GetMapping("/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
}
