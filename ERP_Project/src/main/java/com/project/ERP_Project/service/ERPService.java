package com.project.ERP_Project.service;

import com.project.ERP_Project.dto.StudentPercentageDTO;
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

    public StudentPercentageDTO findTopper() {
        List<StudentPercentageDTO> list = findAllPercentage();
        double maxPercentage = Integer.MIN_VALUE;
        StudentPercentageDTO marks = null;
        for(StudentPercentageDTO percentageDTO:list){
            if(percentageDTO.getPercentage()>maxPercentage){
                maxPercentage = percentageDTO.getPercentage();
                marks = percentageDTO;
            }
        }
        return marks;
    }

//    public List<String> findAllPercentage() {
//        List<String> percentages = new ArrayList<>();
//
//        for(Student student:students){
//            List<Double> marks = student.getMarks();
//            double perc = 0.0;
//            for(Double mark:marks){
//                perc+=mark;
//            }
//            perc*=0.2;
//            String res = student.getName()+" "+student.getRollNumber()+" "+perc;
//            percentages.add(res);
//        }
//        return percentages;
//    }

    public List<StudentPercentageDTO> findAllPercentage(){
        List<StudentPercentageDTO> percentages = new ArrayList<>();
        for(Student student:students){
            double percentage = 0.0;
            List<Double> marks = student.getMarks();
            for(Double mark:marks){
                percentage+=mark;
            }
            percentage*=0.2;
            StudentPercentageDTO studentPercentageDTO = new StudentPercentageDTO(student.getRollNumber(),student.getName(),percentage);
            percentages.add(studentPercentageDTO);
        }
        return percentages;
    }

    public StudentPercentageDTO leastScorer() {
        List<StudentPercentageDTO> list = findAllPercentage();
        StudentPercentageDTO marks = null;
        double per = Integer.MAX_VALUE;

        for(StudentPercentageDTO student:list){
            if(student.getPercentage()<per){
                per = student.getPercentage();
                marks = student;
            }
        }
        return marks;
    }

//    public void addStudent(Student student) {
//        students.add(student);
//    }
}
