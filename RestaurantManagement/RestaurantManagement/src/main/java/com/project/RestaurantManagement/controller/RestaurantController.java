package com.project.RestaurantManagement.controller;

import com.project.RestaurantManagement.model.RestaurantModel;
import com.project.RestaurantManagement.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant-app")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/add-restaurant")
    public String addRestaurant(@RequestBody RestaurantModel restaurant){
        restaurantService.addRestaurant(restaurant);
        return "added successfully";
    }

    @GetMapping("/get-restaurants")
    public List<RestaurantModel> getRestaurant(){
        return restaurantService.getRestaurant();
    }

    @GetMapping("/name/{name}")
    public RestaurantModel getSingleRestaurant(@PathVariable String name){
        return restaurantService.findByName(name);
    }
}
