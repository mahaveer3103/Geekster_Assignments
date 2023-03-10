package com.example.chatApplication.service;

import com.example.chatApplication.dao.StatusRepository;
import com.example.chatApplication.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public int saveStatus(Status status) {
        return statusRepository.save(status).getStatusId();
    }

    public void updateStatus(Status status, int statusId) {
        status.setStatusId(statusId);
        statusRepository.save(status);
    }
}
