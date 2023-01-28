package com.example.creasy.controller;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class EventRessourceController {
    @Autowired
    private EventService eventService;

    @GetMapping(value="/allevents")
    public List<EventDto> allEvents(Principal p) {
        return eventService.getAllEventDto(p.getName());
    }


}
