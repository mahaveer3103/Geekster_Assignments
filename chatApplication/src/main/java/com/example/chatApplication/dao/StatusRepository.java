package com.example.chatApplication.dao;

import com.example.chatApplication.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Integer> {
}
