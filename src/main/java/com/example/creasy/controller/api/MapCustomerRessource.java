package com.example.creasy.controller.api;

import com.example.creasy.controller.dto.EventDto;
import com.example.creasy.controller.dto.MapCustomerDto;
import com.example.creasy.service.EventService;
import com.example.creasy.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MapCustomerRessource {
    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value="/allcustomers", method= RequestMethod.GET)
    public List<MapCustomerDto> allEvents() {
        return partnerService.getAllMapCustomeDto();
    }
}
