package com.example.project.controller;

import com.example.project.repository.entity.Partner;
import com.example.project.service.PartnerService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/partners")
public class PartnerController {
    private PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }


    // Display all partners
//    @GetMapping("/all")
//    public String displayAllPartners(Model model) {
//        List<Partner> partnerList = partnerService.getAllPartner();
//        model.addAttribute("partners", partnerList);
//        return "partnerListView";
//
//    }

    // Display clients
    @GetMapping("/all-prospects")
    public String displayAllProspects(Model model) {
        List<Partner> prospectList = partnerService.getAllProspect();
        model.addAttribute("prospects", prospectList);
        return "prospect/prospectList";
    }

    // Display prospects
    @GetMapping("/all-customers")
    public String displayAllCustomers(Model model) {
        List<Partner> customerList = partnerService.getAllCustomer();
        model.addAttribute("customers", customerList);
        return "customer/customerList";
    }

    // Display specific partner
    @GetMapping("/details/{id}")
    public String displaySpecificPartner(Model model, @PathVariable Long id){
        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute("partner", partner);
        return "partnerDetail";
    }

    




}
