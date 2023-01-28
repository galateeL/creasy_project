package com.example.creasy.controller;

import com.example.creasy.model.Company;
import com.example.creasy.model.Partner;
import com.example.creasy.model.StateProspect;
import com.example.creasy.model.User;
import com.example.creasy.service.CompanyService;
import com.example.creasy.service.NoteService;
import com.example.creasy.service.PartnerService;
import com.example.creasy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private PartnerService partnerService;

    private CompanyService companyService;

    private NoteService noteService;

    private UserService userService;

    public DashboardController(PartnerService partnerService, CompanyService companyService, NoteService noteService, UserService userService) {

        this.partnerService = partnerService;
        this.companyService = companyService;
        this.noteService = noteService;
        this.userService = userService;
    }


    // Display dashboard
    @GetMapping("")
    public String displayDashboard(Principal principal, Model model) {

        User user = userService.getUserByMail(principal.getName());
        List<Partner> prospectList = partnerService.findAllProspectsByList(StateProspect.ENDED,StateProspect.TO_FOLLOW_UP , user.getEmail());
        partnerService.setToFollowUpIfNecessary(prospectList);

        // Number of prospects with specific state by user

        int prospectsToFollowUp = partnerService.findNumberOfProspectsToFollowUp(StateProspect.TO_FOLLOW_UP, principal.getName());
        model.addAttribute("prospectsToFollowUp", prospectsToFollowUp);

        int prospectsNotStarted = partnerService.findNumberOfProspectsInNotStarted(StateProspect.NOT_STARTED, principal.getName());
        model.addAttribute("prospectsNotStarted", prospectsNotStarted);

        int prospectsInProgress = partnerService.findNumberOfProspectsInProgress(StateProspect.IN_PROGRESS, principal.getName());
        model.addAttribute("prospectsInProgress", prospectsInProgress);

        // Number of customers by user
        int customersByUser = partnerService.findAllCustomersByUser(principal.getName());
        model.addAttribute("customersByUser", customersByUser);

        // Number of prospects by user
        int propectsByUser = partnerService.findAllProspectsByUser(principal.getName());
        model.addAttribute("propectsByUser", propectsByUser);

        // Number of companies by user
        List <Partner> partnerList = user.getPartnerList();
        Set<Company> companySet = partnerList.stream().map(partner -> partner.getCompany())
                .collect(Collectors.toSet());

        int companiesByUser = companySet.size();
        model.addAttribute("companiesByUser", companiesByUser);

        return "dashboard";
    }

}
