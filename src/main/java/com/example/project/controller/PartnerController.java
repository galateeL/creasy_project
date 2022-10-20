package com.example.project.controller;

import com.example.project.repository.CreateCustomer;
import com.example.project.repository.CreatePartner;
import com.example.project.repository.CreateProspect;
import com.example.project.repository.EditPartner;
import com.example.project.repository.entity.Partner;
import com.example.project.repository.entity.StateProspect;
import com.example.project.service.PartnerService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
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

    // Add prospect - Display addProspect Form
    @GetMapping("/add-prospect")
    public String displayAddProspectForm(Model model) {
        StateProspect[] stateProspectsArray = StateProspect.values();
        List<StateProspect> stateProspectList = Arrays.asList(stateProspectsArray);
        model.addAttribute("stateProspects", stateProspectList);
        return "prospect/addProspect";
    }

    // Add prospect - Save in DB
    @PostMapping("/add-prospect")
    public String addProspect(CreateProspect createProspect) {
        partnerService.createProspect(createProspect);
        return "redirect:/partners/all-prospects";

    }

    // Add customer - Display addCustomer Form
   @GetMapping("/add-customer")
    public String displayAddCustomerForm(Model model) {
        return "customer/addCustomer";
   }


    // Add customer - Save in DB
    @PostMapping("/add-customer")
    public String addCustomer(CreateProspect createProspect) {
        partnerService.createCustomer(createProspect);
        return "redirect:/partners/all-customers";
    }

    // Delete specific prospect
    @PostMapping("/delete-prospect/{id}")
    public String deleteProspect(@PathVariable(value="id") Long id) {
        partnerService.deletePartner(id);
        return "redirect:/partners/all-prospects";
    }

    // Delete specific customer
    @PostMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable(value="id") Long id) {
        partnerService.deletePartner(id);
        return "redirect:/partners/all-customers";
    }

    // Edit specific customer - Display form
    @GetMapping("/edit-customer/{id}")
    public String displayEditCustomerForm(Model model,@PathVariable Long id) {
        Partner customer = partnerService.findPartnerById(id);
        model.addAttribute("customer", customer);
        return "customer/editCustomer";
    }

    // Edit specific customer
    @PostMapping("/edit-customer/{id}")
    public String editCustomer(EditPartner editPartner, @PathVariable Long id){
        partnerService.editPartner(id, editPartner);
        return "redirect:/partners/details/{id}";
    }

    // Edit specific prospect - Display form
    @GetMapping("/edit-prospect/{id}")
    public String displayEditProspectForm(Model model,@PathVariable Long id) {
        Partner prospect = partnerService.findPartnerById(id);
        model.addAttribute("prospect", prospect);
        return "prospect/editProspect";
    }

    // Edit specific prospect
    @PostMapping("/edit-prospect/{id}")
    public String editProspect(EditPartner editPartner, @PathVariable Long id){
        partnerService.editPartner(id, editPartner);
        return "redirect:/partners/details/{id}";
    }













}
