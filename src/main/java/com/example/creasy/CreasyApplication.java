package com.example.creasy;

import com.example.creasy.repository.CompanyRepository;
import com.example.creasy.repository.entity.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreasyApplication implements CommandLineRunner {

    private CompanyRepository companyRepository;

    public CreasyApplication(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CreasyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

        Company company = new Company(
                "Activity Area",
                "Additional address",
                "Address",
                "City",
                "email@mail.com",
                "logo.png",
                "Name",
                "0299887766",
                "0612345678",
                "12345",
                "123 568 941 00056",
                "http://www.webSite.com",
                "48.866667",
                "2.333333"
        );
        companyRepository.save(company);

        Company company2 = new Company(
                "Activity Area",
                "Additional address",
                "Address",
                "City",
                "email@mail.com",
                "logo.png",
                "Name",
                "0299887766",
                "0612345678",
                "12345",
                "123 568 941 00056",
                "http://www.webSite.com",
                "48.866667",
                "2.333333"
        );
        companyRepository.save(company2);

    }



}
