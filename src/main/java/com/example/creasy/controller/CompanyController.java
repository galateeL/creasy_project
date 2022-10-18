package com.example.creasy.controller;

import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "companiesListView";
    }

    @GetMapping(path = "/details/{id}")
    public String displaySpecificCompany(Model model, @PathVariable("id") Long id){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "companyDetailsView";
    }
}
