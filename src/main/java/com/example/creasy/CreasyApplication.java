package com.example.creasy;


import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;

import com.example.creasy.repository.PartnerRepository;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CreasyApplication implements CommandLineRunner {

    private CompanyRepository companyRepository;

    private PartnerRepository partnerRepository;

    public CreasyApplication(CompanyRepository companyRepository, PartnerRepository partnerRepository) {
        this.companyRepository = companyRepository;
        this.partnerRepository = partnerRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(CreasyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

        Company company = new Company(
                "Activity Area",
                "Address",
                "City",
                "email@mail.com",
                "logo.png",
                "Name",
                "0299887766",
                "12345",
                "123 568 941 00056",
                "http://www.webSite.com",
                "48.866667",
                "2.333333",
                LocalDate.now()
        );
        companyRepository.save(company);

        Company company2 = new Company(
                "Activity Area",
                "Address",
                "City",
                "email@mail.com",
                "logo.png",
                "Name",
                "0299887766",
                "12345",
                "123 568 941 00056",
                "http://www.webSite.com",
                "48.866667",
                "2.333333",
                LocalDate.now()
        );
        companyRepository.save(company2);

        // Client instanciation + save dans la DB
        Partner client1 = new Partner("Jean", "Mary", "m.jean@gmail.com", "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", "0212545847", "0741581245", "Chef de projet", StateProspect.ENDED);
        partnerRepository.save(client1);

        // Prospect instanciation + save dans la DB
        Partner prospect1 = new Partner("Morrin", "Louis", "l.morrin@gmail.com", "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", "0212545747", "0641581245", "Chef de projet",  StateProspect.IN_PROGRESS);
        partnerRepository.save(prospect1);

    }

}
