package com.example.creasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapPartnerController {
    @GetMapping("/map")
    public String displaySigninForm(Model m){
        return "mapCustomer";
    }
}
