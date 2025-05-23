package com.example.laptopshop.controller.admin;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.service.ProductService;
import com.example.laptopshop.service.UploadService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller("adminProductController")
@RequestMapping("/admin")
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;
    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }
    @GetMapping("/product")
    public String getAdminProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products",products);
        return "admin/product/index";
    }
    @GetMapping("/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }
    @PostMapping("/product/create")
    public String storeProduct(@ModelAttribute("newProduct") @Valid Product product, BindingResult bindingResult,
                               @RequestParam("file") MultipartFile file)
    {
        List<FieldError> errors = bindingResult.getFieldErrors();
        errors.forEach(fieldError -> System.out.println(">>>>>> " + fieldError.getField() + " " + fieldError.getDefaultMessage()));
        if(bindingResult.hasErrors()){
            return "admin/product/create";
        }
        String fileName = uploadService.handleSaveUpload(file, "product");
        productService.handleCreateProduct(product,fileName);
        return "redirect:/admin/product";
    }
    @GetMapping("/product/update/{id}")
    public String editProduct(@PathVariable long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "admin/product/update";
    }
    @PostMapping("/product/update")
    public String updateProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                                @RequestParam MultipartFile file, Model model)
    {
        boolean errors = productService.hasError(bindingResult);
        if(errors){
            model.addAttribute("product",product);
            return "admin/product/update";
        }
        String fileName = null;
        if(file != null && !file.isEmpty()){
            fileName = uploadService.handleSaveUpload(file, "product");
        }
        productService.handleUpdateProduct(product, fileName);
        return "redirect:/admin/product";
    }
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("product", new Product());
        return "admin/product/delete";
    }
    @PostMapping("/product/delete")
    public String deleteProduct(@ModelAttribute Product product){
        productService.handleDeleteProductById(product.getId());
        return "redirect:/admin/product";
    }
}
