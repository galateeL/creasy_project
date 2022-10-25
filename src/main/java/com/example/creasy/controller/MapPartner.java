package com.example.creasy.controller;

import com.example.creasy.controller.dto.CreateUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapPartner {
    @GetMapping("/map")
    public String displaySigninForm(Model m){
        return "mapCustomer";
    }
}
