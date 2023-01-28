package com.example.creasy.controller;

import com.example.creasy.controller.dto.*;
import com.example.creasy.model.*;
import com.example.creasy.service.CompanyService;
import com.example.creasy.service.NoteService;
import com.example.creasy.service.PartnerService;
import com.example.creasy.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/partners")
public class PartnerController {
    private PartnerService partnerService;
    private CompanyService companyService;
    private NoteService noteService;
    private UserService userService;

    public PartnerController(PartnerService partnerService, CompanyService companyService, NoteService noteService, UserService userService) {


        this.partnerService = partnerService;
        this.companyService = companyService;
        this.noteService = noteService;
        this.userService = userService;

    }

    private static final String PARTNER_VALUE = "partner";
    private static final String COMPANIES_VALUE = "companies";
    private static final String REDIRECT_DETAILS_CUSTOMER = "redirect:/partners/details-customer/{id}";
    private static final String REDIRECT_DETAILS_PROSPECT = "redirect:/partners/details-prospect/{id}";

    // Display prospects
    @GetMapping("/all-prospects")
    public String displayAllProspects(Principal principal, Model model, @Param("keywordProspect") String keywordProspect, @Param("sort") String sort, @Param("state") String state) {

        User user = userService.getUserByMail(principal.getName());

        List<Partner> prospectList = partnerService.getAllProspect(keywordProspect, sort, user.getEmail());
        if(state != null && !state.isEmpty()) {
            prospectList.removeIf(partner -> !partner.getStateProspect().name().equals(state));
        }
        model.addAttribute("prospects", prospectList);
        return "prospect/prospectList";
    }

    // Display customers
    @GetMapping("/all-customers")
    public String displayAllCustomers(Principal principal, Model model, @Param("keywordCustomer") String keywordCustomer, @Param("sort") String sort){

        User user = userService.getUserByMail(principal.getName());

        List<Partner> customerList = partnerService.getAllCustomer(keywordCustomer, sort, user.getEmail());

        model.addAttribute("customers", customerList);
        return "customer/customerList";
    }


    // Display specific prospect
    @GetMapping("/details-prospect/{id}")
    public String displaySpecificProspect(Model model, @PathVariable Long id){
        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute(PARTNER_VALUE, partner);

        List<Note> noteList  = noteService.getAllNotesByPartner(partner);
        model.addAttribute("notes", noteList);

        model.addAttribute("events", noteList);

        return "prospect/prospectDetail";
    }

    // Display specific customer
    @GetMapping("/details-customer/{id}")
    public String displaySpecificCustomer(Model model, @PathVariable Long id){

        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute(PARTNER_VALUE, partner);


        List<Note> noteList  = noteService.getAllNotesByPartner(partner);
        model.addAttribute("notes", noteList);


        model.addAttribute("events", noteList);
        return "customer/customerDetail";
    }

    // Add new note to partner - Save in DB
    @PostMapping("/{id}/add-note")
    public String addNote(CreateNoteDto createNote, @PathVariable Long id, Model model) {

        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute(PARTNER_VALUE, partner);

        noteService.addNote(createNote, partner);
        if(partner.getStateProspect() == StateProspect.ENDED) {
            return REDIRECT_DETAILS_CUSTOMER;
        } else {
            return REDIRECT_DETAILS_PROSPECT;
        }

    }



    // Add prospect - Display addProspect Form
    @GetMapping("/add-prospect")
    public String displayAddProspectForm(Model model) {
       StateProspect[] stateProspectsArray = StateProspect.values();

      List <StateProspect> stateProspectList = new ArrayList<>();
      for(StateProspect stateProspect : stateProspectsArray){
          if(stateProspect != StateProspect.ENDED){
              stateProspectList.add(stateProspect);
          }
      }


        List<Company> companyList  = companyService.getAllCompany();
        model.addAttribute("stateProspects", stateProspectList);
        model.addAttribute(COMPANIES_VALUE, companyList);
        return "prospect/addProspect";
    }

    // Add prospect - Save in DB
    @PostMapping("/add-prospect")
    public String addProspect(Principal principal, CreateProspectDto createProspect) {

        User user = userService.getUserByMail(principal.getName());

        partnerService.createProspect(createProspect, user);
        return "redirect:/partners/all-prospects";

    }

    // Add customer - Display addCustomer Form
   @GetMapping("/add-customer")
    public String displayAddCustomerForm(Model model) {
      List<Company> companyList  = companyService.getAllCompany();
      model.addAttribute(COMPANIES_VALUE, companyList);
        return "customer/addCustomer";
   }


    // Add customer - Save in DB
    @PostMapping("/add-customer")
    public String addCustomer(Principal principal, CreateCustomerDto createCustomer) {

        User user = userService.getUserByMail(principal.getName());

        partnerService.createCustomer(createCustomer, user);
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
        model.addAttribute(COMPANIES_VALUE, companyList);
        return "customer/editCustomer";
    }

    // Edit specific customer
    @PostMapping("/edit-customer/{id}")
    public String editCustomer(EditPartnerDto editPartner, @PathVariable Long id){
        partnerService.editPartner(id, editPartner);
        return REDIRECT_DETAILS_CUSTOMER;
    }

    // Edit specific prospect - Display form
    @GetMapping("/edit-prospect/{id}")
    public String displayEditProspectForm(Model model,@PathVariable Long id) {
        Partner prospect = partnerService.findPartnerById(id);
        model.addAttribute("prospect", prospect);
        List<Company> companyList  = companyService.getAllCompany();
        model.addAttribute(COMPANIES_VALUE, companyList);
        StateProspect[] stateProspectsArray = StateProspect.values();
        List<StateProspect> stateProspectList = Arrays.asList(stateProspectsArray);
        model.addAttribute("stateProspects", stateProspectList);
        return "prospect/editProspect";
    }

    // Edit specific prospect
    @PostMapping("/edit-prospect/{id}")
    public String editProspect(EditPartnerDto editPartner, @PathVariable Long id){
        partnerService.editPartner(id, editPartner);

       return REDIRECT_DETAILS_PROSPECT;

    }

    // Edit specific note - Display form
    @GetMapping("/edit-note/{id}")
    public String displayEditNoteForm (Model model, @PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        Partner partner = note.getPartner();
        model.addAttribute("note", note);
        model.addAttribute(PARTNER_VALUE, partner);
        return "editNoteForm";
    }

    // Edit specific note
    @PostMapping("/edit-note/{id}")
    public String editNote(EditNoteDto editNote, @PathVariable Long id){
        noteService.editNote(id, editNote);

        Note note = noteService.getNoteById(id);
        Partner partner = note.getPartner();

        if(partner.getStateProspect() == StateProspect.ENDED) {
            return "redirect:/partners/details-customer/" + partner.getId();
        } else {
            return "redirect:/partners/details-prospect/" +partner.getId();
        }
    }


    // Delete specific note - Display form
    @GetMapping("/delete-note/{id}")
    public String displayDeleteNoteForm(Model model,@PathVariable Long id) {
        Note note = noteService.getNoteById(id);

        Partner partner = note.getPartner();
        model.addAttribute(PARTNER_VALUE, partner);
        model.addAttribute("note", note);

        return "deleteNoteForm";
    }


    // Delete specific note
    @PostMapping("/delete-note/{id}")
    public String deleteNote(@PathVariable(value="id") Long id) {
        Note note = noteService.getNoteById(id);
        Partner partner = note.getPartner();
        noteService.deleteNote(note);

        if(partner.getStateProspect() == StateProspect.ENDED) {
            return "redirect:/partners/details-customer/" + partner.getId();
        } else {
            return "redirect:/partners/details-prospect/" + partner.getId();
        }
    }


    // Add dunning period to a prospect - Save in DB
    @PostMapping("{id}/add-dunning-period")
    public String addDunningPeriod(CreateDunningDto createDunning, @PathVariable Long id, Model model) {

        Partner partner = partnerService.findPartnerById(id);
        model.addAttribute(PARTNER_VALUE, partner);

        partnerService.addDunningPeriod(partner.getId(), createDunning);


        if (partner.getStateProspect() == StateProspect.ENDED) {
            return REDIRECT_DETAILS_CUSTOMER;
        } else {
            return REDIRECT_DETAILS_PROSPECT;
        }

    }

}
