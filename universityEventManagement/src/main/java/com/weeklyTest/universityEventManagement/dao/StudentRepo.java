package com.weeklyTest.universityEventManagement.dao;

import com.weeklyTest.universityEventManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
