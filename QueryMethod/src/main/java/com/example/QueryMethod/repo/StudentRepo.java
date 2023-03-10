package com.example.QueryMethod.repo;

import com.example.QueryMethod.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


//private Integer id;
//private String firstName;
//private String lastName;
//private Integer age;
//private Date startDate;
//private boolean active;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    Student findByFirstName(String name);
    Student findByFirstNameOrLastName(String firstName,String lastName);

    Student findByFirstNameAndLastName(String firstName,String lastName);

    List<Student> findByStartDate(Date date);
}
