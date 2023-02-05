package com.project.RestaurantManagement.model;

public class RestaurantModel {

    private String name;
    private int totalStaff;
    private String address;
    private String number;

    public RestaurantModel() {
    }


    public RestaurantModel(String name, int totalStaff, String address, String number) {
        this.name = name;
        this.totalStaff = totalStaff;
        this.address = address;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalStaff() {
        return totalStaff;
    }

    public void setTotalStaff(int totalStaff) {
        this.totalStaff = totalStaff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
