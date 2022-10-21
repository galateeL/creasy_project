package com.example.creasy.service;

import com.example.creasy.controller.CreateCompany;
import com.example.creasy.exception.CompanyNotFoundException;
import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    private StorageService storageService;

    public CompanyService(CompanyRepository companyRepository, StorageService storageService) {
        this.companyRepository = companyRepository;
        this.storageService = storageService;
    }

    public List<Company> getAllCompany(){
        return (List<Company>) this.companyRepository.findAll();
    }

    public Company getCompanyById(long id) throws CompanyNotFoundException{
        return this.companyRepository
                .findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    public List<Company> searchByName(String searchValue){
        return this.companyRepository.findCompanyByNameContaining(searchValue);
    }

    public void addCompany(CreateCompany createCompany){

        Company company = new Company();
        company.setActivityArea(createCompany.getActivityArea());
        company.setAddress(createCompany.getAddress());
        company.setCity(createCompany.getCity());
        company.setEmail(createCompany.getEmail());

        company.setName(createCompany.getName());
        company.setPhoneNumberFixr(createCompany.getPhoneNumberFixr());
        company.setPostalCode(createCompany.getPostalCode());
        company.setSiret(createCompany.getSiret());
        company.setWebSite(createCompany.getWebSite());
        company.setLatitude(createCompany.getLatitude());
        company.setLongitude(createCompany.getLongitude());
        company.setCreationDate(createCompany.getCreationDate());

        MultipartFile picture = createCompany.getLogoFile();
        if (picture == null || picture.isEmpty()) {
            company.setLogo(createCompany.getLogo());
        } else {
            storageService.store(picture);
            company.setLogo("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        this.companyRepository.save(company);
    }


    public void deleteCompany(Company company){
        this. companyRepository.delete(company);
    }

    public Company editCompany(Long id, CreateCompany editCompany){

        Company company = this.companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));

        company.setActivityArea(editCompany.getActivityArea());
        company.setAddress(editCompany.getAddress());
        company.setCity(editCompany.getCity());
        company.setEmail(editCompany.getEmail());
        company.setLogo(editCompany.getLogo());
        company.setName(editCompany.getName());
        company.setPhoneNumberFixr(editCompany.getPhoneNumberFixr());
        company.setPostalCode(editCompany.getPostalCode());
        company.setSiret(editCompany.getSiret());
        company.setWebSite(editCompany.getWebSite());
        company.setLatitude(editCompany.getLatitude());
        company.setLongitude(editCompany.getLongitude());
        company.setCreationDate(editCompany.getCreationDate());

        return this.companyRepository.save(company);

    }

}
