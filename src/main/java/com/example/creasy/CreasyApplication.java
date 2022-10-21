package com.example.creasy;

import com.example.creasy.repository.CompanyRepository;

import com.example.creasy.repository.UserRepository;
import com.example.creasy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.creasy.repository.PartnerRepository;
import com.example.creasy.repository.entity.Company;
import com.example.creasy.repository.entity.Partner;
import com.example.creasy.repository.entity.StateProspect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CreasyApplication implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    private PartnerRepository partnerRepository;
    private CompanyRepository companyRepository;
    public CreasyApplication(PartnerRepository partnerRepository, CompanyRepository companyRepository) {

        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
    }


    public static void main(String[] args) {

        SpringApplication.run(CreasyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

        // Company instanciation + save in DB
        Company company1 = new Company("Technologies", "", "2 rue du phare", "Nantes", "capgemini@cap.com", "https://lespetitesannoncesdemarine.files.wordpress.com/2019/07/capgemini-logo.jpg?w=1200", "Capgemini", "021547854", "14587965412", "44000", "test Siret", "website", "1245", "5541");
        companyRepository.save(company1);

        // Company instanciation + save in DB
        Company company2 = new Company("Technologies", "", "2 rue du phare", "Nantes", "capgemini@cap.com", "https://lespetitesannoncesdemarine.files.wordpress.com/2019/07/capgemini-logo.jpg?w=1200", "Avera", "021547854", "14587965412", "44000", "test Siret", "website", "1245", "5541");
        companyRepository.save(company2);


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user1=new User("kevin-laurent@hotmail.fr",true, "https://www " +
                ".usinenouvelle" +
                ".com/mediatheque/0/7/5/000353570_896x598_c.jpg", passwordEncoder.encode("a"), "k",
                "k");

        User user2=new User("kevin.laurentt@outlook.fr",false, "https://www.usinenouvelle" +
                ".com/mediatheque/0/7/5/000353570_896x598_c.jpg", passwordEncoder.encode("a"), "k",
                "k");

        userRepository.save(user1);
        userRepository.save(user2);

        // Client instanciation + save dans la DB
        Partner client1 = new Partner("Jean", "Mary", "m.jean@gmail.com", "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", "0212545847", "0741581245", "Chef de projet", StateProspect.ENDED, company1);
        partnerRepository.save(client1);

        // Prospect instanciation + save in DB
        Partner prospect1 = new Partner("Morrin", "Louis", "l.morrin@gmail.com", "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", "0212545747", "0641581245", "Chef de projet",  StateProspect.IN_PROGRESS, company2);
        partnerRepository.save(prospect1);
    }
}
