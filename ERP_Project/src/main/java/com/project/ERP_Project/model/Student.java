package com.project.ERP_Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor //All argument constructor
@Data //Combination of @Getter @Setter @toString & @HashCode
public class Student {
    private int rollNumber;
    private String name;
    private String gender;
    private List<Double> marks; //5 subjects
    private String city;

}
