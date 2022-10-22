package com.example.creasy.controller;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.service.EventService;
import com.example.creasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping("/bookForm")
    public String showBookForm(Model m){
        
        m.addAttribute("command",new CreateBook());
        m.addAttribute("authors",authorList);

        return "bookForm";
    }
    @PostMapping(value="/save")
    public String save(@ModelAttribute("user") EventDto eventDto){
        eventService.addEvent(eventDto);

        return "redirect:/books/all";
    }
}
