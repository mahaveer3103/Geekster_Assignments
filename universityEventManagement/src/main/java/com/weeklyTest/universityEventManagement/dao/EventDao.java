package com.weeklyTest.universityEventManagement.dao;

import com.weeklyTest.universityEventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventDao extends JpaRepository<Event,Integer> {

    public List<Event> findEventByDate(String date);

}
