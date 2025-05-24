package com.example.laptopshop.service;

import com.example.laptopshop.domain.Product;
import com.example.laptopshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public Product handleSaveProduct(Product product){
        return productRepository.save(product);
    }
    public Product handleCreateProduct(Product product, String fileName){
        product.setImage(fileName);
        return handleSaveProduct(product);
    }
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }
    public boolean hasError(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(error -> System.out.println(">>>>>> "+ error.getField()+" "+ error.getDefaultMessage()));
            return true;
        }
        return false;
    }
    public void handleUpdateProduct(Product product, String fileName){
        Product product1 = this.getProductById(product.getId()).get();
        if(product1 != null){
            if(fileName != null && !fileName.isEmpty()){
                product1.setImage(fileName);
            }
            product1.setName(product.getName());
            product1.setFactory(product.getFactory());
            product1.setQuantity(product.getQuantity());
            product1.setDetailDesc(product.getDetailDesc());
            product1.setShortDesc(product.getShortDesc());
            product1.setSold(product.getSold());
            product1.setTarget(product.getTarget());
            product1.setPrice(product.getPrice());
        }
        handleSaveProduct(product1);
    }
    public void handleDeleteProductById(long id){
        Product product = this.getProductById(id).get();
        productRepository.delete(product);
    }
    public long getProductCount() {
        return productRepository.count();
    }
}
