package com.weeklyTest.universityEventManagement.service;

import com.weeklyTest.universityEventManagement.dao.EventDao;
import com.weeklyTest.universityEventManagement.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventDao eventDao;


    public int addEvent(Event requestEvent) {
        return eventDao.save(requestEvent).getEventId();
    }

    public void updateEvent(Integer eventId, Event event) {
        event.setEventId(eventId);
        eventDao.save(event);
    }

    public void deleteEvent(Integer eventId) {
        eventDao.deleteById(eventId);
    }


    public List<Event> getEvent(String date) {
        if(date!=null){
            return eventDao.findEventByDate(date);
        }else {
            return eventDao.findAll();
        }
    }
}
