package com.example.project;

import com.example.project.repository.PartnerRepository;
import com.example.project.repository.entity.Partner;
import com.example.project.repository.entity.StateProspect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    private PartnerRepository partnerRepository;

    public ProjectApplication(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("COMMAND LINE RUNNER");

        // Client instanciation + save dans la DB
        Partner client1 = new Partner("Jean", "Mary", "m.jean@gmail.com", "34 rue des peupliers 44000 NANTES", "https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", "0212545847", "0741581245", "Chef de projet", true, StateProspect.ENDED);
        partnerRepository.save(client1);

        // Prospect instanciation + save dans la DB
        Partner prospect1 = new Partner("Morrin", "Louis", "l.morrin@gmail.com", "35 rue des roses 44000 NANTES", "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=871&q=80", "0212545747", "0641581245", "Chef de projet", false, StateProspect.IN_PROGRESS);
        partnerRepository.save(prospect1);
    }
}
