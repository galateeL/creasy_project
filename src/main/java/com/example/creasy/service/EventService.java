package com.example.creasy.service;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.repository.EventRepository;
import com.example.creasy.repository.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;
    public void addEvent(EventDto eventDto){
        Event event = new Event();
        event.setAddress(eventDto.getAddress());
        event.setDescription(eventDto.getDescription());
        event.setName(eventDto.getName());
        event.setEndDate(eventDto.getEndDate());
        event.setStartDate(eventDto.getStartDate());
        event.setWholeDay(eventDto.isWholeDay());

        this.eventRepository.save(event);
    }
}
