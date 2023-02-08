package com.project.countApp.controller;

import com.project.countApp.model.UrlHitModel;
import com.project.countApp.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    public UrlHitService urlHitService;

    @GetMapping("username/{username}/count")
    public UrlHitModel count(@PathVariable String username){
//        System.out.println(urlHitService.countIncrement(username));
        return urlHitService.countIncrement(username);
    }
}
