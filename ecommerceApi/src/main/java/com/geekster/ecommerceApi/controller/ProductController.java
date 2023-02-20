package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.Product;
import com.geekster.ecommerceApi.service.ProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProduct")
    public List<Product> getProduct(@Nullable @RequestParam String category){
        return productService.getAllProducts(category);
    }

    @DeleteMapping("/deleteProduct")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer productId){
        return productService.deleteProduct(productId);
    }
}
