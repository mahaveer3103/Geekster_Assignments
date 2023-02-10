package com.example.LibraryModel.model;

import java.util.List;

public class Library {
    private String name;
    private String address;
    private String phNo;
    private List<String> facilities;

    public Library(String name, String address, String phNo, List<String> facilities) {
        this.name = name;
        this.address = address;
        this.phNo = phNo;
        this.facilities = facilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phNo='" + phNo + '\'' +
                ", facilities=" + facilities +
                '}';
    }
}
