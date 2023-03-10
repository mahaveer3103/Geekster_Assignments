package com.geekster.hibernateMapping.dao;

import com.geekster.hibernateMapping.model.Laptop;
import com.geekster.hibernateMapping.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop,Integer> {

    Laptop findByStudent(Student student);


}
