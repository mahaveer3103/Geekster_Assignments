package com.weeklyTest.universityEventManagement.controller;

import com.weeklyTest.universityEventManagement.model.Student;
import com.weeklyTest.universityEventManagement.service.StudentService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student requestStudent){
        int id = service.addStudent(requestStudent);
        return new ResponseEntity<>("Saved with id - "+id, HttpStatus.CREATED);
    }

    @PutMapping("/updateStudent/id/{id}/department/{department}")
    public ResponseEntity<String> updateStudentDepartment(@PathVariable int id,@PathVariable String department){
        service.updateStudentDepartment(id,department);
        return new ResponseEntity<>("Student updated with department - "+department,HttpStatus.OK);
    }

    @GetMapping("/get-student/")
    public ResponseEntity<List<Student>> getUser(@Nullable @RequestParam Integer studentId){
        List<Student> list = service.getUser(studentId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
