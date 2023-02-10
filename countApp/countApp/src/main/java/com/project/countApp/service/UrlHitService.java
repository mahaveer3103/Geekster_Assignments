package com.project.countApp.service;

import com.project.countApp.model.UrlHitModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {

    static Map<String,Integer> map = new HashMap<>();

    int count=1;
    public UrlHitModel countIncrement(String username) {
        UrlHitModel urlHitModel = new UrlHitModel();
        int count = map.getOrDefault(username,0)+1;
        map.put(username,count);
        UrlHitModel v = new UrlHitModel(username,count);
        return v;
    }
}
