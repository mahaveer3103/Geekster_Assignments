package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.ProductRepository;
import com.geekster.ecommerceApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProducts(String category) {
        if(null != category){
            List<Product> list = new ArrayList<>();
            list.addAll(productRepository.findByCategory(category));
            return list;
        }
        return productRepository.findAll();
    }

    public ResponseEntity<String> deleteProduct(Integer productId) {
        try {
            productRepository.deleteById(productId);
            return new ResponseEntity<>("Product Deleted", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
