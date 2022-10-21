package com.example.creasy.controller;

import com.example.creasy.repository.CreateCustomer;
import com.example.creasy.repository.CreateNote;
import com.example.creasy.repository.CreateProspect;
import com.example.creasy.repository.EditPartner;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;
import com.example.creasy.service.CompanyService;
import com.example.creasy.service.NoteService;
import com.example.creasy.service.PartnerService;
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

    private CompanyService companyService;

    private NoteService noteService;

    public PartnerController(PartnerService partnerService, CompanyService companyService, NoteService noteService) {

        this.partnerService = partnerService;
        this.companyService = companyService;
        this.noteService = noteService;
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


    // Display specific prospect
    @GetMapping("/details-prospect/{id}")
    public String displaySpecificProspect(Model model, @PathVariable Long id){
        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute("partner", partner);

        List<Note> noteList  = noteService.getAllNotesByPartner(partner);
        model.addAttribute("notes", noteList);

        return "prospect/prospectDetail";
    }

    // Display specific customer
    @GetMapping("/details-customer/{id}")
    public String displaySpecificCustomer(Model model, @PathVariable Long id){

        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute("partner", partner);

        List<Note> noteList  = noteService.getAllNotesByPartner(partner);
        model.addAttribute("notes", noteList);
        return "customer/customerDetail";
    }

    // Add new note to partner - Save in DB
    @PostMapping("/{id}/add-note")
    public String addNote(CreateNote createNote, @PathVariable Long id,Model model) {
        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute("partner", partner);

        noteService.addNote(createNote, partner);
        if(partner.getStateProspect() == StateProspect.ENDED) {
            return "redirect:/partners/details-customer/{id}";
        } else {
            return "redirect:/partners/details-prospect/{id}";
        }

    }




    // Add prospect - Display addProspect Form
    @GetMapping("/add-prospect")
    public String displayAddProspectForm(Model model) {
        StateProspect[] stateProspectsArray = StateProspect.values();
        List<StateProspect> stateProspectList = Arrays.asList(stateProspectsArray);
        List<Company> companyList  = companyService.getAllCompany();
        model.addAttribute("stateProspects", stateProspectList);
        model.addAttribute("companies", companyList);
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
      List<Company> companyList  = companyService.getAllCompany();
      model.addAttribute("companies", companyList);
        return "customer/addCustomer";
   }


    // Add customer - Save in DB
    @PostMapping("/add-customer")
    public String addCustomer(CreateCustomer createCustomer) {
        partnerService.createCustomer(createCustomer);
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
        List<Company> companyList  = companyService.getAllCompany();
        model.addAttribute("companies", companyList);
        return "customer/editCustomer";
    }

    // Edit specific customer
    @PostMapping("/edit-customer/{id}")
    public String editCustomer(EditPartner editPartner, @PathVariable Long id, Model model){
        partnerService.editPartner(id, editPartner);
        return "redirect:/partners/details-customer/{id}";
    }

    // Edit specific prospect - Display form
    @GetMapping("/edit-prospect/{id}")
    public String displayEditProspectForm(Model model,@PathVariable Long id) {
        Partner prospect = partnerService.findPartnerById(id);
        model.addAttribute("prospect", prospect);
        List<Company> companyList  = companyService.getAllCompany();
        model.addAttribute("companies", companyList);
        return "prospect/editProspect";
    }

    // Edit specific prospect
    @PostMapping("/edit-prospect/{id}")
    public String editProspect(EditPartner editPartner, @PathVariable Long id){
        partnerService.editPartner(id, editPartner);
        return "redirect:/partners/details-prospect/{id}";
    }


}
