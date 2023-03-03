package com.weeklyTest.universityEventManagement.service;

import com.weeklyTest.universityEventManagement.dao.StudentRepo;
import com.weeklyTest.universityEventManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;
    public int addStudent(Student requestStudent) {
        return repo.save(requestStudent).getStudentId();
    }

    public void updateStudentDepartment(int id, String department) {
        Student student = repo.findById(id).get();
        student.setDepartment(department);
        repo.save(student);
    }

    public List<Student> getUser(Integer studentId) {
        List<Student> list;
        if(studentId!=null){
            list = repo.findById(studentId).stream().toList();
        }else {
            list = repo.findAll();
        }
        return list;
    }
}
