package com.example.creasy.controller;


import com.example.creasy.controller.dto.CreateEventDto;
import com.example.creasy.model.Event;
import com.example.creasy.model.Partner;
import com.example.creasy.model.StateProspect;
import com.example.creasy.model.User;
import com.example.creasy.service.EventService;
import com.example.creasy.service.PartnerService;
import com.example.creasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
class EventController {
	

	@Autowired
	private PartnerService partnerService;

	@Autowired
	private EventService eventService;

	@Autowired
	private UserService userService;

	@PostMapping("/{id}/add-event")
	public String addEvent(Principal p, CreateEventDto createEvent, @PathVariable Long id, Model model) {
		User user=  userService.getUserByMail(p.getName());

		Partner partner = partnerService.findPartnerById(id);
		model.addAttribute("partner", partner);

		eventService.addEvent(createEvent, partner,user);
		if(partner.getStateProspect() == StateProspect.ENDED) {
			return "redirect:/partners/details-customer/{id}";
		} else {
			return "redirect:/partners/details-prospect/{id}";
		}

	}
	@GetMapping("/evenement{id}")
	public String displaySpecificCustomer(Model model, @PathVariable Long id){

		Event event  = eventService.getEventById(id);
		model.addAttribute("event", event);
		return "detailEvenement";
	}
	// Edit specific note - Display form
	@GetMapping("/edit-event/{id}")
	public String displayEditEventForm (Model model, @PathVariable Long id) {
		Event event = eventService.getEventById(id);
		Partner partner = event.getPartner();
		model.addAttribute("event", event);
		model.addAttribute("partner", partner);
		return "editEventForm";
	}

	// Edit specific note
	@PostMapping("/edit-event/{id}")
	public String editNote(CreateEventDto createEvent, @PathVariable Long id){
		eventService.editEvent(id);

		Event event = eventService.getEventById(id);
		Partner partner = event.getPartner();

		if(partner.getStateProspect() == StateProspect.ENDED) {
			return "redirect:/partners/details-customer/" + partner.getId();
		} else {
			return "redirect:/partners/details-prospect/" +partner.getId();
		}
	}


	// Delete specific note - Display form
	@GetMapping("/delete-event/{id}")
	public String displayDeleteNoteForm(Model model,@PathVariable Long id) {
		Event event = eventService.getEventById(id);

		Partner partner = event.getPartner();
		model.addAttribute("partner", partner);
		model.addAttribute("event", event);

		return "deleteEventForm";
	}


	// Delete specific note
	@PostMapping("/delete-event/{id}")
	public String deleteNote(@PathVariable(value="id") Long id) {
		Event event = eventService.getEventById(id);
		Partner partner = event.getPartner();
		eventService.deleteEvent(event);

		if(partner.getStateProspect() == StateProspect.ENDED) {
			return "redirect:/partners/details-customer/" + partner.getId();
		} else {
			return "redirect:/partners/details-prospect/" + partner.getId();
		}
	}
}
