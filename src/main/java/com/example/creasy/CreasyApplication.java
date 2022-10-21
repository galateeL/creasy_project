package com.example.creasy;

import com.example.creasy.repository.UserRepository;
import com.example.creasy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CreasyApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CreasyApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
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

    }

}
