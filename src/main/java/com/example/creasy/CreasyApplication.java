package com.example.creasy;

import com.example.creasy.repository.CompanyRepository;

import com.example.creasy.repository.NoteRepository;
import com.example.creasy.repository.UserRepository;
import com.example.creasy.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.creasy.repository.PartnerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class CreasyApplication implements CommandLineRunner {


    @Autowired
    private UserRepository userRepository;

    private PartnerRepository partnerRepository;
    private CompanyRepository companyRepository;

    private NoteRepository noteRepository;

    public CreasyApplication(PartnerRepository partnerRepository, CompanyRepository companyRepository, NoteRepository noteRepository) {

        this.partnerRepository = partnerRepository;
        this.companyRepository = companyRepository;
        this.noteRepository = noteRepository;
    }


    public static void main(String[] args) {

        SpringApplication.run(CreasyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

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

        // Company instanciation + save in DB
        Company company1 = new Company("Technologies", "", "2 rue du phare", "Nantes", "capgemini@cap.com", "https://lespetitesannoncesdemarine.files.wordpress.com/2019/07/capgemini-logo.jpg?w=1200", "Capgemini", "021547854", "14587965412", "44000", "test Siret", "website", "1245", "5541");
        companyRepository.save(company1);

        // Company instanciation + save in DB
        Company company2 = new Company("Technologies", "", "2 rue du phare", "Nantes", "capgemini@cap.com", "https://lespetitesannoncesdemarine.files.wordpress.com/2019/07/capgemini-logo.jpg?w=1200", "Avera", "021547854", "14587965412", "44000", "test Siret", "website", "1245", "5541");
        companyRepository.save(company2);


        // Client instanciation + save dans la DB
        Partner client1 = new Partner("Jean", "Mary", "m.jean@gmail.com", "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", "0212545847", "0741581245", "Chef de projet", StateProspect.ENDED, company1, LocalDateTime.now());
        partnerRepository.save(client1);

        // Client instanciation + save dans la DB
        Partner client2 = new Partner("Zebra", "Maurice", "m.jean@gmail.com", "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", "0212545847", "0741581245", "Chef de projet", StateProspect.ENDED, company2, LocalDateTime.now());
        partnerRepository.save(client2);

        // Prospect instanciation + save in DB
        Partner prospect1 = new Partner("Morrin", "Louis", "l.morrin@gmail.com", "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", "0212545747", "0641581245", "Chef de projet",  StateProspect.TO_FOLLOW_UP, company2, LocalDateTime.now());
        partnerRepository.save(prospect1);

        // Prospect instanciation + save in DB
        Partner prospect2 = new Partner("Uno", "Jeanne", "l.morrin@gmail.com", "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", "0212545747", "0641581245", "Chef de projet",  StateProspect.IN_PROGRESS, company1, LocalDateTime.now());
        partnerRepository.save(prospect2);

        // Note instanciation + save in DB
        Note note1 = new Note("First note with this customer ...... lorem ipsum", LocalDateTime.now(), client1);
        noteRepository.save(note1);

        // Note instanciation + save in DB
        Note note2 = new Note("Second note with this customer ...... lorem ipsum", LocalDateTime.now(), client1);
        noteRepository.save(note2);

        // Note instanciation + save in DB
        Note note3 = new Note("Second note with this customer ...... lorem ipsum", LocalDateTime.now(), prospect1);
        noteRepository.save(note3);

    }
}
