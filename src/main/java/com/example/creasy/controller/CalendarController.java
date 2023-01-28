package com.example.creasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class CalendarController {


	@GetMapping(value="/staticcalendar")
	public ModelAndView staticcalendar() {
		return new ModelAndView("staticcalendar");
	}

	

}