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
        Company athemis = new Company();
        athemis.setActivityArea("Law office");
        athemis.setAddress("86 rue d'Amsterdam");
        athemis.setCity("Paris");
        athemis.setEmail("contact@arthemis.com");
        athemis.setLogo("https://athemis.ch/zone/img/logo.png");
        athemis.setName("Athemis");
        athemis.setPhoneNumberFixr("0153349393");
        athemis.setPostalCode("75009");
        athemis.setSiret("12356894100056");
        athemis.setWebSite("https://www.athemis.fr/");
        athemis.setLatitude("48.862725");
        athemis.setLongitude("2.287592");
        athemis.setCreationDate(LocalDate.now());
        companyRepository.save(athemis);

        Company attiqueAvocats = new Company();
        attiqueAvocats.setActivityArea("Law office");
        attiqueAvocats.setAddress("50 rue Etienne Marcel");
        attiqueAvocats.setCity("Paris");
        attiqueAvocats.setEmail("info@attique-avocats.fr");
        attiqueAvocats.setLogo("https://i.postimg.cc/g0jmcB5L/1632849510403.jpg");
        attiqueAvocats.setName("Attique Avocats");
        attiqueAvocats.setPhoneNumberFixr("0153002020");
        attiqueAvocats.setPostalCode("75017");
        attiqueAvocats.setSiret("12356894100056");
        attiqueAvocats.setWebSite("https://www.attique-avocats.fr/");
        attiqueAvocats.setLatitude("48.8655111");
        attiqueAvocats.setLongitude("2.342628");
        attiqueAvocats.setCreationDate(LocalDate.now());
        companyRepository.save(attiqueAvocats);

        Company inExtenso = new Company();
        inExtenso.setActivityArea("Accountants office");
        inExtenso.setAddress("1 rue Benjamin Franklin");
        inExtenso.setCity("Saint-Herblain");
        inExtenso.setEmail("info@inextenso.fr");
        inExtenso.setLogo("https://media.cylex-locale.fr/companies/1035/2830/logo/logo.jpg");
        inExtenso.setName("In Extenso");
        inExtenso.setPhoneNumberFixr("0251801800");
        inExtenso.setPostalCode("44800");
        inExtenso.setSiret("18356754100056");
        inExtenso.setWebSite("https://www.inextenso.fr/");
        inExtenso.setLatitude("47.2268028");
        inExtenso.setLongitude("-1.6206648");
        inExtenso.setCreationDate(LocalDate.now());
        companyRepository.save(inExtenso);

        Company berny = new Company();
        berny.setActivityArea("Agri-food");
        berny.setAddress("4 Rue Voltaire");
        berny.setCity("Nantes");
        berny.setEmail("info@berny.fr");
        berny.setLogo("https://finance-et-compagnies.com/storage/media/2063/NsrC8m4z_400x400.jpg");
        berny.setName("Berny");
        berny.setPhoneNumberFixr("0246820154");
        berny.setPostalCode("44000");
        berny.setSiret("85356754100056");
        berny.setWebSite("https://www.bernypack.fr/");
        berny.setLatitude("47.2128496");
        berny.setLongitude("-1.563358");
        berny.setCreationDate(LocalDate.now());
        companyRepository.save(berny);


        Company kiplin = new Company();
        kiplin.setActivityArea("Healthcare");
        kiplin.setAddress("28 bis Quai François Mitterrand");
        kiplin.setCity("Nantes");
        kiplin.setEmail("contact@kiplin.fr");
        kiplin.setLogo("https://www.kiplin.com/wp-content/themes/swimmingpool/dist/img/logo.png");
        kiplin.setName("Kiplin");
        kiplin.setPhoneNumberFixr("0285528226");
        kiplin.setPostalCode("44200");
        kiplin.setSiret("44356754100056");
        kiplin.setWebSite("https://www.kiplin.com/fr/");
        kiplin.setLatitude("47.2073991");
        kiplin.setLongitude("-1.5557436");
        kiplin.setCreationDate(LocalDate.now());
        companyRepository.save(kiplin);

        Company josepho = new Company();
        josepho.setActivityArea("Event furniture");
        josepho.setAddress("12 Rue Palouzié");
        josepho.setCity("Saint-Ouen-sur-Seine");
        josepho.setEmail("contact@josepho.fr");
        josepho.setLogo("https://ecole-du-digital.com/wp-content/uploads/2020/02/josepho-logo-300x300.png");
        josepho.setName("Josepho");
        josepho.setPhoneNumberFixr("0556860958");
        josepho.setPostalCode("93400");
        josepho.setSiret("74356754100056");
        josepho.setWebSite("https://josepho.io/");
        josepho.setLatitude("48.904718");
        josepho.setLongitude("2.327452");
        josepho.setCreationDate(LocalDate.now());
        companyRepository.save(josepho);

        Company impactTrack = new Company();
        impactTrack.setActivityArea("Sustainable development");
        impactTrack.setAddress("4 Rue des Cadeniers");
        impactTrack.setCity("Nantes");
        impactTrack.setEmail("contact@impact-track.fr");
        impactTrack.setLogo("https://uploads-ssl.webflow.com/623b273e7582dd116b190742/6255a7294ce4918ffcc198c7_Impacts-track-logo-2-lignes.png");
        impactTrack.setName("Impact Track");
        impactTrack.setPhoneNumberFixr("026860958");
        impactTrack.setPostalCode("44000");
        impactTrack.setSiret("14356754100056");
        impactTrack.setWebSite("https://impacttrack.org/fr/");
        impactTrack.setLatitude("47.2119085");
        impactTrack.setLongitude("-1.5648019");
        impactTrack.setCreationDate(LocalDate.now());
        companyRepository.save(impactTrack);

        Company nudge = new Company();
        nudge.setActivityArea("Communication");
        nudge.setAddress("95 Ave Parmentier");
        nudge.setCity("Paris");
        nudge.setEmail("info@nudge.fr");
        nudge.setLogo("https://www.finsmes.com/wp-content/uploads/2016/06/nudge_logo_blue.png");
        nudge.setName("Nudge");
        nudge.setPhoneNumberFixr("015861974");
        nudge.setPostalCode("74011");
        nudge.setSiret("34356754100078");
        nudge.setWebSite("https://nudge.co/");
        nudge.setLatitude("48.8662876");
        nudge.setLongitude("2.3736184");
        nudge.setCreationDate(LocalDate.now());
        companyRepository.save(nudge);


        Company persilEtRomarin = new Company();
        persilEtRomarin.setActivityArea("Cook");
        persilEtRomarin.setAddress("64 Rue Lamartine");
        persilEtRomarin.setCity("Talence");
        persilEtRomarin.setEmail("info@persil-romarin.fr");
        persilEtRomarin.setLogo("https://i.postimg.cc/LsS18WZT/Persil-Romarin.jpg");
        persilEtRomarin.setName("Persil & Romarin");
        persilEtRomarin.setPhoneNumberFixr("038864974");
        persilEtRomarin.setPostalCode("33400");
        persilEtRomarin.setSiret("74356754100078");
        persilEtRomarin.setWebSite("https://persiletromarin.fr/");
        persilEtRomarin.setLatitude("44.8119293");
        persilEtRomarin.setLongitude("-0.5860946");
        persilEtRomarin.setCreationDate(LocalDate.now());
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
        Partner client1 = new Partner();
        client1.setLastname("Mongin");
        client1.setFirstname("Lucie");
        client1.setEmail("l.mongin@gmail.com");
        client1.setPictureUrl("https://images.unsplash.com/photo-1580489944761-15a19d654956?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=761&q=80");
        client1.setFixedPhoneNumber("0212545847");
        client1.setMobilePhoneNumber("0741581245");
        client1.setPositionHeld("Chef de projet");
        client1.setStateProspect(StateProspect.ENDED);
        client1.setCompany(berny);
        client1.setUser(rosa);
        client1.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client1);

        Partner client2 = new Partner();
        client2.setLastname("Zebra");
        client2.setFirstname("Maurice");
        client2.setEmail("m.zebra@gmail.com");
        client2.setPictureUrl("https://images.unsplash.com/photo-1600878459138-e1123b37cb30?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=706&q=80");
        client2.setFixedPhoneNumber("0412545847");
        client2.setMobilePhoneNumber("0641581245");
        client2.setPositionHeld("Avocat");
        client2.setStateProspect(StateProspect.ENDED);
        client2.setCompany(attiqueAvocats);
        client2.setUser(rosa);
        client2.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client2);

        Partner client3 = new Partner();
        client3.setLastname("Hugin");
        client3.setFirstname("Laury");
        client3.setEmail("l.hugin@gmail.com");
        client3.setPictureUrl("https://images.unsplash.com/photo-1534751516642-a1af1ef26a56?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=689&q=80");
        client3.setFixedPhoneNumber("0112545847");
        client3.setMobilePhoneNumber("0747581245");
        client3.setPositionHeld("Chef de projet");
        client3.setStateProspect(StateProspect.ENDED);
        client3.setCompany(josepho);
        client3.setUser(rosa);
        client3.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client3);

        Partner client4 = new Partner();
        client4.setLastname("Maurice");
        client4.setFirstname("Laurent");
        client4.setEmail("l.maurice@gmail.com");
        client4.setPictureUrl("https://images.unsplash.com/photo-1570295999919-56ceb5ecca61?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80");
        client4.setFixedPhoneNumber("0212545847");
        client4.setMobilePhoneNumber("0637541245");
        client4.setPositionHeld("Comptable");
        client4.setStateProspect(StateProspect.ENDED);
        client4.setCompany(inExtenso);
        client4.setUser(rosa);
        client4.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client4);

        // Prospects - ROSA
        Partner prospect1 = new Partner();
        prospect1.setLastname("Pelletier");
        prospect1.setFirstname("Edouard");
        prospect1.setEmail("e.pelletier@gmail.com");
        prospect1.setPictureUrl("https://images.unsplash.com/photo-1566492031773-4f4e44671857?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        prospect1.setFixedPhoneNumber("0412545747");
        prospect1.setMobilePhoneNumber("0741581245");
        prospect1.setPositionHeld("Chef de projet");
        prospect1.setStateProspect(StateProspect.NOT_STARTED);
        prospect1.setCompany(nudge);
        prospect1.setUser(rosa);
        prospect1.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(prospect1);

        Partner prospect2 = new Partner();
        prospect2.setLastname("Unos");
        prospect2.setFirstname("Louise");
        prospect2.setEmail("l.unos@gmail.com");
        prospect2.setPictureUrl("https://images.unsplash.com/photo-1544717305-2782549b5136?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        prospect2.setFixedPhoneNumber("0212545747");
        prospect2.setMobilePhoneNumber("0641581245");
        prospect2.setPositionHeld("Manager");
        prospect2.setStateProspect(StateProspect.TO_FOLLOW_UP);
        prospect2.setCompany(persilEtRomarin);
        prospect2.setUser(rosa);
        prospect2.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(prospect2);


        // Customers - LEGRAND

        Partner client5 = new Partner();
        client5.setLastname("Piron");
        client5.setFirstname("Alexis");
        client5.setEmail("a.piron@gmail.com");
        client5.setPictureUrl("https://images.unsplash.com/photo-1618077360395-f3068be8e001?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80");
        client5.setFixedPhoneNumber("0212545847");
        client5.setMobilePhoneNumber("0741581245");
        client5.setPositionHeld("Office manager");
        client5.setStateProspect(StateProspect.ENDED);
        client5.setCompany(kiplin);
        client5.setUser(legrand);
        client5.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client5);

        Partner client6 = new Partner();
        client6.setLastname("Nobel");
        client6.setFirstname("Anais");
        client6.setEmail("a.nobel@gmail.com");
        client6.setPictureUrl("https://images.unsplash.com/photo-1543270122-f7a11ad44f3a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        client6.setFixedPhoneNumber("0112545847");
        client6.setMobilePhoneNumber("0744581845");
        client6.setPositionHeld("Avocate");
        client6.setStateProspect(StateProspect.ENDED);
        client6.setCompany(athemis);
        client6.setUser(legrand);
        client6.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client6);

        Partner client7 = new Partner();
        client7.setLastname("Guaubert");
        client7.setFirstname("Antoine");
        client7.setEmail("a.gaubert@gmail.com");
        client7.setPictureUrl("https://images.unsplash.com/photo-1607081692251-d689f1b9af84?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        client7.setFixedPhoneNumber("0212545877");
        client7.setMobilePhoneNumber("0647581245");
        client7.setPositionHeld("Manager'");
        client7.setStateProspect(StateProspect.ENDED);
        client7.setCompany(josepho);
        client7.setUser(legrand);
        client7.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(client7);


        // Prospects - LEGRAND
        Partner prospect3 = new Partner();
        prospect3.setLastname("Alouan");
        prospect3.setFirstname("Joris");
        prospect3.setEmail("j.allouan@gmail.com");
        prospect3.setPictureUrl("https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        prospect3.setFixedPhoneNumber("0412545747");
        prospect3.setMobilePhoneNumber("0741581245");
        prospect3.setPositionHeld("Chef de projet");
        prospect3.setStateProspect(StateProspect.NOT_STARTED);
        prospect3.setCompany(impactTrack);
        prospect3.setUser(legrand);
        prospect3.setRegisterDate(LocalDateTime.now());
        partnerRepository.save(prospect3);

        Partner prospect4 = new Partner();
        prospect4.setLastname("Oudin");
        prospect4.setFirstname("Lise");
        prospect4.setEmail("l.oudin@gmail.com");
        prospect4.setPictureUrl("https://images.unsplash.com/photo-1542740348-39501cd6e2b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80");
        prospect4.setFixedPhoneNumber("0112545747");
        prospect4.setMobilePhoneNumber("0785581245");
        prospect4.setPositionHeld("Manager");
        prospect4.setStateProspect(StateProspect.TO_FOLLOW_UP);
        prospect4.setCompany(persilEtRomarin);
        prospect4.setUser(legrand);
        prospect4.setRegisterDate(LocalDateTime.now());
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
