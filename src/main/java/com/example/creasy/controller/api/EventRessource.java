package com.example.creasy.controller.api;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class EventRessource {
    @Autowired
    private EventService eventService;

    @RequestMapping(value="/allevents", method= RequestMethod.GET)
    public List<EventDto> allEvents(Principal p) {
        return eventService.getAllEventDto(p.getName());
    }


}
