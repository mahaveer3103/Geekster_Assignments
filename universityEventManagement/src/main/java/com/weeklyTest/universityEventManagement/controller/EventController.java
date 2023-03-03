package com.weeklyTest.universityEventManagement.controller;

import com.weeklyTest.universityEventManagement.model.Event;
import com.weeklyTest.universityEventManagement.service.EventService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    EventService service;

    @PostMapping("/add-event")
    public ResponseEntity<String> addEvent(@RequestBody Event requestEvent){
        int id = service.addEvent(requestEvent);
        return new ResponseEntity<>("Saved event with id - "+id, HttpStatus.CREATED);
    }

    @PutMapping("/update-event/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Integer eventId,@RequestBody Event event){
        service.updateEvent(eventId,event);
        return new ResponseEntity<>("Event updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete-event")
    public ResponseEntity<String> deleteEvent(@PathVariable Integer eventId){
        service.deleteEvent(eventId);
        return new ResponseEntity<>("Event Deleted",HttpStatus.OK);
    }

    @GetMapping("/get_event")
    public ResponseEntity<List<Event>> getEvent(@Nullable@RequestParam String date){
        List<Event> list = service.getEvent(date);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
