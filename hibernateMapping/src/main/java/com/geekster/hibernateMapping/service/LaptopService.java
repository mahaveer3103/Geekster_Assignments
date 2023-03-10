package com.geekster.hibernateMapping.service;
import com.geekster.hibernateMapping.dao.LaptopRepository;
import com.geekster.hibernateMapping.model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public String addLaptop(Laptop laptop){
        Laptop byStudent = laptopRepository.findByStudent(laptop.getStudent());
        if(byStudent==null){
            return laptopRepository.save(laptop).getId()+"";
        }
        return null;
    }

    public Laptop getLaptopById(int id) {
        return laptopRepository.findById(id).get();
    }

    public List<Laptop> getAllLaptop(){
        return laptopRepository.findAll();
    }

    public Integer updateLaptop(Laptop laptopById) {
        return laptopRepository.save(laptopById).getStudent().getID();
    }

    public void deleteLaptop(Integer id) {
        laptopRepository.deleteById(id);
    }


}