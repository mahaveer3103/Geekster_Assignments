package com.example.QueryMethod.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id",nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date startDate;
    private boolean active;

}
