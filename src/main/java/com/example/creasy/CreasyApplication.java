package com.example.creasy;


import com.example.creasy.model.*;
import com.example.creasy.repository.*;

import com.example.creasy.repository.CompanyRepository;


import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private EventRepository eventRepository;

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

        // Companies
        Company athemis = new Company("Law office", "86 rue d'Amsterdam", "Paris", "contact@arthemis.com", "https://athemis.ch/zone/img/logo.png", "Athemis", "0153349393","75009", "12356894100056", "https://www.athemis.fr/", "48.862725", "2.287592", LocalDate.now());
        companyRepository.save(athemis);

        Company attiqueAvocats = new Company("Law office", "50 rue Etienne Marcel", "Paris", "info@attique-avocats.fr","https://i.postimg.cc/g0jmcB5L/1632849510403.jpg", "Attique Avocats", "0153002020","75017", "12356894100056" , "https://www.attique-avocats.fr/", "48.8655111", "2.342628", LocalDate.now());
        companyRepository.save(attiqueAvocats);

        Company inExtenso = new Company("Accountants office", "1 rue Benjamin Franklin", "Saint-Herblain", "info@inextenso.fr","https://media.cylex-locale.fr/companies/1035/2830/logo/logo.jpg", "In Extenso", "0251801800","44800", "18356754100056" , "https://www.inextenso.fr/", "47.2268028", "-1.6206648", LocalDate.now());
        companyRepository.save(inExtenso);

        Company berny = new Company("Agri-food", "4 Rue Voltaire", "Nantes", "info@berny.fr","https://finance-et-compagnies.com/storage/media/2063/NsrC8m4z_400x400.jpg", "Berny", "0246820154","44000", "85356754100056" , "https://www.bernypack.fr/", "47.2128496", "-1.563358", LocalDate.now());
        companyRepository.save(berny);

        Company kiplin = new Company("Healthcare", "28 bis Quai François Mitterrand", "Nantes", "contact@kiplin.fr","https://www.kiplin.com/wp-content/themes/swimmingpool/dist/img/logo.png", "Kiplin", "0285528226","44200", "44356754100056" , "https://www.kiplin.com/fr/", "47.2073991", "-1.5557436", LocalDate.now());
        companyRepository.save(kiplin);

        Company josepho = new Company("Event furniture", "12 Rue Palouzié", "Saint-Ouen-sur-Seine", "contact@josepho.fr","https://ecole-du-digital.com/wp-content/uploads/2020/02/josepho-logo-300x300.png", "Josepho", "0556860958","93400", "74356754100056" , "https://josepho.io/", "48.904718", "2.327452", LocalDate.now());
        companyRepository.save(josepho);

        Company impactTrack = new Company("Sustainable development", "4 Rue des Cadeniers", "Nantes", "contact@impact-track.fr","https://uploads-ssl.webflow.com/623b273e7582dd116b190742/6255a7294ce4918ffcc198c7_Impacts-track-logo-2-lignes.png", "Impact Track", "026860958","44000", "14356754100056" , "https://impacttrack.org/fr/", "47.2119085", "-1.5648019", LocalDate.now());
        companyRepository.save(impactTrack);

        Company nudge = new Company("Communication", "95 Ave Parmentier", "Paris", "info@nudge.fr","https://www.finsmes.com/wp-content/uploads/2016/06/nudge_logo_blue.png", "Nudge", "015861974","74011", "34356754100078" , "https://nudge.co/", "48.8662876", "2.3736184", LocalDate.now());
        companyRepository.save(nudge);

        Company persilEtRomarin = new Company("Cook", "64 Rue Lamartine", "Talence", "info@persil-romarin.fr","https://i.postimg.cc/LsS18WZT/Persil-Romarin.jpg", "Persil & Romarin", "038864974","33400", "74356754100078" , "https://persiletromarin.fr/", "44.8119293", "-0.5860946", LocalDate.now());
        companyRepository.save(persilEtRomarin);



        

        // Users
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User rosa = new User("laurence.rosa@rosa-formation.fr",true, "https://plus.unsplash.com/premium_photo-1661767329669-2ff46c34fffa?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", passwordEncoder.encode("rosa"), "Rosa",
                "Laurence");
        userRepository.save(rosa);


        User legrand =new User("laurent-legrand@gmail.com",false, "https://images.unsplash.com/flagged/photo-1573603867003-89f5fd7a7576?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=746&q=80", passwordEncoder.encode("legrand"), "Legrand",
                "Laurent");
        userRepository.save(legrand);


        User durand =new User("louis-durand@gmail.com",false, "https://images.unsplash.com/photo-1585807515950-bc46d934c28b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", passwordEncoder.encode("durand"), "Durand",
                "Jean");
        userRepository.save(durand);

        User bayon =new User("jean.bayon@gmail.com",false, "https://images.unsplash.com/photo-1585807515950-bc46d934c28b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", passwordEncoder.encode("bayon"), "Bayon",
                "Robert");
        userRepository.save(bayon);





        // Customers - ROSA
        Partner client1 = new Partner("Mongin", "Lucie", "l.mongin@gmail.com", "https://images.unsplash.com/photo-1580489944761-15a19d654956?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=761&q=80", "0212545847", "0741581245", "Chef de projet", StateProspect.ENDED, berny, rosa, LocalDateTime.now());
        partnerRepository.save(client1);

        Partner client2 = new Partner("Zebra", "Maurice", "m.zebra@gmail.com", "https://images.unsplash.com/photo-1600878459138-e1123b37cb30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=706&q=80", "0412545847", "0641581245", "Avocat", StateProspect.ENDED, attiqueAvocats, rosa, LocalDateTime.now());
        partnerRepository.save(client2);

        Partner client3 = new Partner("Hugin", "Laury", "l.hugin@gmail.com", "https://images.unsplash.com/photo-1534751516642-a1af1ef26a56?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=689&q=80", "0112545847", "0747581245", "Chef de projet", StateProspect.ENDED, josepho, rosa, LocalDateTime.now());
        partnerRepository.save(client3);

        Partner client4 = new Partner("Maurice", "Laurent", "l.maurice@gmail.com", "https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80", "0212545847", "0637541245", "Comptable", StateProspect.ENDED, inExtenso, rosa, LocalDateTime.now());
        partnerRepository.save(client4);





        // Prospects - ROSA

        Partner prospect1 = new Partner("Pelletier", "Edouard", "e.pelletier@gmail.com", "https://images.unsplash.com/photo-1566492031773-4f4e44671857?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0412545747", "0741581245", "Chef de projet",  StateProspect.NOT_STARTED, nudge, rosa, LocalDateTime.now());
        partnerRepository.save(prospect1);

        Partner prospect2 = new Partner("Unos", "Louise", "l.unos@gmail.com", "https://images.unsplash.com/photo-1544717305-2782549b5136?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0212545747", "0641581245", "Manager",  StateProspect.TO_FOLLOW_UP, persilEtRomarin, rosa, LocalDateTime.now());
        partnerRepository.save(prospect2);





        // Customers - LEGRAND
        Partner client5 = new Partner("Piron", "Alexis", "a.piron@gmail.com", "https://images.unsplash.com/photo-1618077360395-f3068be8e001?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80", "0212545847", "0741581245", "Office manager", StateProspect.ENDED, kiplin, legrand, LocalDateTime.now());
        partnerRepository.save(client5);

        Partner client6 = new Partner("Nobel", "Anais", "a.nobel@gmail.com", "https://images.unsplash.com/photo-1543270122-f7a11ad44f3a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0112545847", "0744581845", "Avocate", StateProspect.ENDED, athemis, legrand, LocalDateTime.now());
        partnerRepository.save(client6);

        Partner client7 = new Partner("Guaubert", "Antoine", "a.gaubert@gmail.com", "https://images.unsplash.com/photo-1607081692251-d689f1b9af84?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0212545877", "0647581245", "Manager'", StateProspect.ENDED, josepho, legrand, LocalDateTime.now());
        partnerRepository.save(client7);





        // Prospects - LEGRAND
        Partner prospect3 = new Partner("Alouan", "Joris", "j.allouan@gmail.com", "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0412545747", "0741581245", "Chef de projet",  StateProspect.NOT_STARTED, impactTrack, legrand, LocalDateTime.now());
        partnerRepository.save(prospect3);

        Partner prospect4 = new Partner("Oudin", "Lise", "l.oudin@gmail.com", "https://images.unsplash.com/photo-1542740348-39501cd6e2b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", "0112545747", "0785581245", "Manager",  StateProspect.TO_FOLLOW_UP, persilEtRomarin, legrand, LocalDateTime.now());
        partnerRepository.save(prospect4);






        // Notes - customers
        Note note1 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(), client1);
        noteRepository.save(note1);

        Note note2 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), client1);
        noteRepository.save(note2);

        Note note3 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(), client2);
        noteRepository.save(note3);

        Note note4 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), client3);
        noteRepository.save(note4);

        Note note5 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(), client5);
        noteRepository.save(note5);

        Note note6 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), client6);
        noteRepository.save(note6);

        Note note7 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), client6);
        noteRepository.save(note7);






        // Notes - prospects

        Note note8 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(),prospect1);
        noteRepository.save(note8);

        Note note9 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), prospect1);
        noteRepository.save(note9);

        Note note10 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(), prospect2);
        noteRepository.save(note10);

        Note note11 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), prospect3);
        noteRepository.save(note11);

        Note note12 = new Note("Nulla facilisi. Maecenas nec semper enim. Nam a velit posuere mi commodo lacinia id at neque. Aliquam imperdiet pellentesque volutpat. Pellentesque sollicitudin varius augue.", LocalDateTime.now(), prospect3);
        noteRepository.save(note12);

        Note note13 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), prospect4);
        noteRepository.save(note13);

        Note note14 = new Note("Proin pellentesque euismod arcu vulputate interdum. Etiam tempor congue ante, a blandit est fringilla non. Nullam non metus commodo nunc elementum auctor mattis eu purus. ", LocalDateTime.now(), prospect4);
        noteRepository.save(note14);





        // Events - ROSA
        Event event1 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",client1, rosa);
        eventRepository.save(event1);

        Event event2 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",client2, rosa);
        eventRepository.save(event2);

        Event event3 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",prospect1, rosa);
        eventRepository.save(event3);

        Event event4 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",client3, rosa);
        eventRepository.save(event4);

        Event event5 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",prospect2, rosa);
        eventRepository.save(event5);




        // Events - LEGRAND
        Event event6 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",client1, legrand);
        eventRepository.save(event6);

        Event event7 = new Event("Proin pellentesque euismod arcu vulputate",LocalDateTime.now(),LocalDateTime.now(),"3 rue de la pierre, 4400 Nantes",client2, legrand);
        eventRepository.save(event7);
    }

}
