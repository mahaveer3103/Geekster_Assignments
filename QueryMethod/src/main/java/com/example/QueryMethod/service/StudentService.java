package com.example.QueryMethod.service;

import com.example.QueryMethod.model.Student;
import com.example.QueryMethod.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    Student findByFirstName(String name){
        Student byFirstname = studentRepo.findByFirstName(name);
        return  byFirstname;
    }

    List<Student> getStudentByAdmission(Date date){
        return studentRepo.findByStartDate(date);
    }

    List<Student> findAllStudent(){
//        studentRepo.findAll(Sort.by("age"));
    }
}
