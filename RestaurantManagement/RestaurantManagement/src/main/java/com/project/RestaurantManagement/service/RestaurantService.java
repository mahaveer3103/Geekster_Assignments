package com.project.RestaurantManagement.service;

import com.project.RestaurantManagement.model.RestaurantModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    List<RestaurantModel> list = new ArrayList<>();

    public void addRestaurant(RestaurantModel restaurant){
        list.add(restaurant);
    }

    public List<RestaurantModel> getRestaurant(){
        return list;
    }

    public RestaurantModel findByName(String name) {
        RestaurantModel resultantRestaurant = null;
        for(int i=0; i<list.size(); i++){
            RestaurantModel restaurant = list.get(i);
            if(restaurant.getName().equals(name))
                resultantRestaurant=restaurant;
        }
        return resultantRestaurant;
    }
}
