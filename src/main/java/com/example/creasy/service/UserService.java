package com.example.creasy.service;

import com.example.creasy.controller.dto.CreateUser;
import com.example.creasy.controller.dto.UpdateUser;
import com.example.creasy.exception.UserNotFoundException;
import com.example.creasy.repository.UserRepository;
import com.example.creasy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    private StorageService storageService;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void register(CreateUser createUser){
        MultipartFile picture = createUser.getPictureFile();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User newUser = new User();
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUser.getPassword()));
        newUser.setPictureUrl(createUser.getPictureUrl());
        newUser.setFirstName(createUser.getFirstName());
        newUser.setLastName(createUser.getLastName());
        if(picture.isEmpty() || picture == null){
            newUser.setPictureUrl(createUser.getPictureUrl());
        }else{
            storageService.store(picture);
            newUser.setPictureUrl("http://localhost:8080/images/"+ picture.getOriginalFilename());
        }
        this.userRepository.save(newUser);
    }

    public void update(UpdateUser updateUser){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepository.findById(updateUser.getId()).get();

        user.setEmail(updateUser.getEmail());
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPictureUrl(updateUser.getPictureUrl());
        user.setId(updateUser.getId());

        if  (!updateUser.getPassword().equals(user.getPassword())){
            user.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        }
        this.userRepository.save(user);
    }
    public User getDetailUser(long id) throws UserNotFoundException {

        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    public User getUserByMail(String mail) {
        return userRepository.findByEmail(mail);
    }

    public List<User> getAllUser() {
        return (List<User>)this.userRepository.findAll();
    }
    public void deleteUser(String mail){
        userRepository.deleteByEmail(mail);
    }
}

