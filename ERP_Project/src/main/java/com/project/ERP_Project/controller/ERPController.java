package com.project.ERP_Project.controller;

import com.project.ERP_Project.dto.StudentPercentageDTO;
import com.project.ERP_Project.model.Student;
import com.project.ERP_Project.service.ERPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/erp-app")
public class ERPController {

    @Autowired
    ERPService erpService;

    @GetMapping("/find-all")
    public List<Student> findAll(){
        return erpService.findAll();
    }

    @GetMapping("find-student/roll_no/{roll_no}")
    public Student findByRollNo(@PathVariable int roll_no){
        return erpService.findByRollNo(roll_no);
    }

//    @PostMapping("/addStudent")
//    public void addStudent(@RequestBody Student student){
//        erpService.addStudent(student);
//    }

    @GetMapping("topper")
    public StudentPercentageDTO findTopper(){
        return erpService.findTopper();
    }

    @GetMapping("find-percentage")
    public List<StudentPercentageDTO> findPercentage(){
        return erpService.findAllPercentage();
    }

    @GetMapping("least")
    public StudentPercentageDTO findLeast(){
        return erpService.leastScorer();
    }

}
