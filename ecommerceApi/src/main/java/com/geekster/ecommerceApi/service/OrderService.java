package com.geekster.ecommerceApi.service;

import com.geekster.ecommerceApi.dao.AddressRepository;
import com.geekster.ecommerceApi.dao.OrderRepository;
import com.geekster.ecommerceApi.dao.ProductRepository;
import com.geekster.ecommerceApi.dao.UserRepository;
import com.geekster.ecommerceApi.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AddressRepository addressRepository;

    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).get();
    }

    public ResponseEntity<String> placeOrder(int userId, int productId, int addressId, Integer quantity) {
        try {
            Order order = new Order();
            order.setUser(userRepository.findById(userId).get());
            order.setProduct(productRepository.findById(productId).get());
            order.setAddress(addressRepository.findById(addressId).get());
            if(null!=quantity){
                order.setProductQuantity(quantity);
            }
            orderRepository.save(order);
            return new ResponseEntity<>("Order Saved Successfully", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Please Enter valid inputs", HttpStatus.BAD_REQUEST);
        }
    }
}
