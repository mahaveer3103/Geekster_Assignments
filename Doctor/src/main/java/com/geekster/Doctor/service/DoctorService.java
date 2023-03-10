package com.geekster.Doctor.service;

import com.geekster.Doctor.dao.DoctorRepository;
import com.geekster.Doctor.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;


    public String saveDoctor(List<Doctor> doctor){
        for (Doctor d:doctor) {
            String doctorName = d.getDoctorName();
            doctorName = "Dr. " + doctorName;
            d.setDoctorName(doctorName);
            doctorRepository.save(d);
//            proxy.save(d);
        }
        return "Saved Successfully";
    }

    public String saveDoctor(Doctor doctor){
        String doctorName = doctor.getDoctorName();
            doctorName = "Dr. " + doctorName;
            doctor.setDoctorName(doctorName);
            doctorRepository.save(doctor);
//            proxy.save(doctor);
        return "Saved Successfully";
    }


    public List<Doctor> getDoctor(String doctorId, String experience) {
        List<Doctor> doctorList = new ArrayList<>();
        if(null != doctorId){
            doctorList.add(doctorRepository.findById(Integer.valueOf(doctorId)).get());
        }else{
            doctorList = doctorRepository.findAll();
            if(null != experience){
                List<Doctor> experienceList = new ArrayList<>();
                for(Doctor doctor:doctorList){
                    if(doctor.getExperience().equals(experience)){
                        experienceList.add(doctor);
                    }
                }
                return experienceList;
            }
        }
       return doctorList;
    }

}
