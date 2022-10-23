package com.example.creasy.service;

import com.example.creasy.controller.dto.CreateEvent;
import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.exception.NoteNotFoundException;
import com.example.creasy.repository.CreateNote;
import com.example.creasy.repository.EditNote;
import com.example.creasy.repository.EventRepository;
import com.example.creasy.repository.UserRepository;
import com.example.creasy.repository.entity.Event;
import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;


    private UserRepository userRepository;

    public EventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<EventDto> getAllEventDto(String userMail){
        List<Event> events= getAllEvent(userMail);
        List<EventDto> eventsDto = new ArrayList<>();
        events.forEach(e->eventsDto.add(e.toEventDto()));
        return eventsDto;
    }

    public List<Event> getAllEvent(String userMail){
        User user= userRepository.findByEmail(userMail) ;
        return eventRepository.findAllEvenements(user);
    }

    public Event getEventById(Long id) throws NoteNotFoundException {
        return this.eventRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public void addEvent(CreateEvent createEvent, Partner partner,User user){

        Event event = new Event();
        event.setTitle(createEvent.getTitle());
        event.setDescription(createEvent.getDescription());
        event.setFinish(createEvent.getFinish());
        event.setStart(createEvent.getStart());
        event.setAddress(createEvent.getAddress());
        event.setPartner(partner);
        event.setUserById(user);

        this.eventRepository.save(event);
    }

    public void deleteEvent(Event event){
        this. eventRepository.delete(event);
    }

    public Event editEvent(Long id, CreateEvent createEvent){

        Event event = this.eventRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        // note.setRegisterDate(LocalDateTime.now());
        // note.setPartner(editNote.getPartner());

        return this.eventRepository.save(event);

    }
}
