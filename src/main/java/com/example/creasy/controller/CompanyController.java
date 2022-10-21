package com.example.creasy.controller;

import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.jnlp.ClipboardService;
import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/list")
    public String displayAllCompanies(Model model, @RequestParam(value = "search", required = false) String searchValue){
        if(searchValue != null){
            List<Company>companyList = companyService.searchByName(searchValue);
            model.addAttribute("companies", companyList);
            model.addAttribute("searchName", searchValue);
        } else {
            List<Company> companyList = companyService.getAllCompany();
            model.addAttribute("companies", companyList);
        }
        return "company/companiesListView";
    }

    @GetMapping(path = "/details/{id}")
    public String displaySpecificCompany(Model model, @PathVariable("id") Long id){
        Company company = companyService.getCompanyById(id);
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
