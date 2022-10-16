package com.example.creasy.service;

import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany(){
        return (List<Company>) this.companyRepository.findAll();
    }
}
