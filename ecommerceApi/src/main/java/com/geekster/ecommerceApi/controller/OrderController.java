package com.geekster.ecommerceApi.controller;

import com.geekster.ecommerceApi.model.Order;
import com.geekster.ecommerceApi.service.OrderService;
import jakarta.annotation.Nullable;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //  http://localhost:8080/order/placeOrder?userId=2&productId=1&addressId=1&quantity=5
    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestParam int userId, @RequestParam int productId, @RequestParam int addressId, @Nullable @RequestParam Integer quantity){
        return orderService.placeOrder(userId,productId,addressId,quantity);
    }


    @GetMapping("/getOrder")
    public Order getOrder(@RequestParam int orderId){
        return orderService.getOrder(orderId);
    }
}
