package com.project.ERP_Project.service;

import com.project.ERP_Project.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ERPService {

    private static final List<Student> students = new ArrayList<>();
    private static int rollNo=0;

    static{
        Student s1 = new Student(++rollNo,"Keval","male",
                List.of(80.0,50.0,78.0,79.0,85.0),"Ahmedabad");
        students.add(s1);
        Student s2 = new Student(++rollNo,"Yash","male",
                List.of(85.0,90.0,88.0,78.0,55.0),"Surat");
        students.add(s2);
        Student s3 = new Student(++rollNo,"Malav","male",
                List.of(85.0,80.0,76.3,79.5,88.0),"Rajkot");
        students.add(s3);
        Student s4 = new Student(++rollNo,"Amanda","female",
                List.of(85.0,70.0,88.0,99.0,84.0),"Ahmedabad");
        students.add(s4);
        Student s5 = new Student(++rollNo,"Emma","female",
                List.of(50.0,87.0,88.0,79.0,85.0),"Mumbai");
        students.add(s5);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findByRollNo(int roll_no) {
        for(Student student:students){
            if(student.getRollNumber()==roll_no) return student;
        }
        return null;
    }

    public Student findTopper() {
    }

    public String findAllPercentage() {

    }

//    public void addStudent(Student student) {
//        students.add(student);
//    }
}
