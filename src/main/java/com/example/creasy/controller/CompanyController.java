package com.example.creasy.controller;

import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.User;
import com.example.creasy.service.CompanyService;
import com.example.creasy.service.PartnerService;
import com.example.creasy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.jnlp.ClipboardService;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;
    private PartnerService partnerService;
    private UserService userService;

    public CompanyController(CompanyService companyService, PartnerService partnerService, UserService userService) {
        this.companyService = companyService;
        this.partnerService = partnerService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String displayAllCompanies(Model model, @RequestParam(value = "search", required = false) String searchValue, Principal principal){

        User user = userService.getUserByMail(principal.getName());
        List <Partner> partnerList = user.getPartnerList();
        Set<Company> companySet = partnerList.stream().map(partner -> partner.getCompany())
                .collect(Collectors.toSet());

        if(searchValue != null){
            companySet.removeIf(company -> !company.getName().toLowerCase().contains(searchValue.toLowerCase()));
            model.addAttribute("companies", companySet);
            model.addAttribute("searchName", searchValue);
        } else {
            model.addAttribute("companies", companySet);
        }
        return "company/companiesListView";
    }

    @GetMapping(path = "/details/{id}")
    public String displaySpecificCompany(Principal principal, Model model, @PathVariable("id") Long id){

        User user = userService.getUserByMail(principal.getName());
        List <Partner> partnerList = user.getPartnerList();
        partnerList.removeIf(partner -> partner.getCompany().getId() != id);

        Company company = companyService.getCompanyById(id);


        model.addAttribute("partner", partnerList);
        model.addAttribute("company", company);
        return "company/companyDetailsView";
    }

    @GetMapping("/add")
    public String createCompanyForm(){
        return "company/companyAddView";
    }

    @PostMapping("/add")
    public String createCompany(CreateCompany createCompany){

        companyService.addCompany(createCompany);

        return "redirect:/companies/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id){

        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies/list";

    }

    @GetMapping("/edit/{id}")
    public String editCompanyForm(Model model, @PathVariable("id") Long id){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company",company);
        return "company/companyEditView";
    }

    @PostMapping("/edit/{id}")
    public RedirectView editCompany(@PathVariable("id") Long id, CreateCompany company){
        companyService.editCompany(id, company );

        return new RedirectView(("/companies/details/" + id));
    }

}
