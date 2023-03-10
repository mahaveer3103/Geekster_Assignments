package com.geekster.Doctor.controller;

import com.geekster.Doctor.dao.DoctorRepository;
import com.geekster.Doctor.model.Doctor;
import com.geekster.Doctor.service.DoctorService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService service;

//    @PostMapping("/doctor")
//    public String saveDoctor(@RequestBody List<Doctor> doctor){
//        service.saveDoctor(doctor);
//        return "Doctor Saved Successfully";
//    }

    @PostMapping("/doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody List<Doctor> requestDoctor){
        String listString = "";
        for(Doctor doctor : requestDoctor) {
            JSONObject json = new JSONObject(doctor);

            List<String> validationList = validatorDoctor(json);

            if (validationList.isEmpty()) {
                Doctor doctor1 = setDoctor(json);
                service.saveDoctor(doctor1);
                return new ResponseEntity<>("Doctor Saved", HttpStatus.CREATED);
            } else {
                for (String s : validationList) {
                    listString += s + ", ";
                }
            }
        }
        return new ResponseEntity<>("Please pass this mandatory parameters - " +
                listString, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctor(@Nullable @RequestParam String doctorId,@Nullable @RequestParam String experience){
        return service.getDoctor(doctorId,experience);
    }

    private List<String> validatorDoctor(JSONObject json) {

        List<String> errorList = new ArrayList<>();

        if(!json.has("doctorId")) {
            errorList.add("doctorId");
        }

        if(!json.has("doctorName")) {
            errorList.add("doctorName");
        }

        if(!json.has("specialization")){
            errorList.add("specialization");
        }
        return errorList;
    }

    public Doctor setDoctor(JSONObject json){
        Doctor doctor = new Doctor();
        String doctorId = json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));
        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);
        String specialization = json.getString("specialization");
        doctor.setSpecialization("specialization");
        if(json.has("experience")){
            String experience = json.getString("experience");
            doctor.setExperience(experience);
        }
        return doctor;
    }

}
