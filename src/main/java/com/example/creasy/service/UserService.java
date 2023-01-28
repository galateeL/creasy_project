package com.example.creasy.service;

import com.example.creasy.controller.dto.CreateUserDto;
import com.example.creasy.controller.dto.UpdateUserDto;
import com.example.creasy.exception.UserNotFoundException;
import com.example.creasy.repository.UserRepository;
import com.example.creasy.model.User;
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
    public void register(CreateUserDto createUser){
        MultipartFile picture = createUser.getPictureFile();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User newUser = new User();
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUser.getPassword()));
        newUser.setPictureUrl(createUser.getPictureUrl());
        newUser.setFirstName(createUser.getFirstName());
        newUser.setLastName(createUser.getLastName());

        if(picture == null || picture.isEmpty()){
            newUser.setPictureUrl(createUser.getPictureUrl());
        }else{
            storageService.store(picture);
            newUser.setPictureUrl("http://localhost:8080/images/"+ picture.getOriginalFilename());
        }
        this.userRepository.save(newUser);
    }

    public void update(UpdateUserDto updateUser){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepository
                .findById(updateUser.getId())
                .orElseThrow(() -> new UserNotFoundException(updateUser.getId()));

        user.setEmail(updateUser.getEmail());
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setId(updateUser.getId());
        MultipartFile picture = updateUser.getPictureFile();
        if(picture != null && !picture.isEmpty()){
            storageService.store(picture);
            user.setPictureUrl("http://localhost:8080/images/"+ picture.getOriginalFilename());
        }

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
    public void deleteUserById(User user){
        this. userRepository.delete(user);
    }
}

