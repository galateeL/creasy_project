package com.example.creasy.controller;

import com.example.creasy.controller.dto.CreateUser;
import com.example.creasy.controller.dto.UpdateUser;
import com.example.creasy.repository.entity.User;
import com.example.creasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signin")
    public String displaySigninForm(Model m){
        m.addAttribute("command",new CreateUser());
        return "signinForm";
    }

    @GetMapping("/signup")
    public String displayRegistrationForm(Model m){
        m.addAttribute("createUser",new CreateUser());
        return "signUpView";
    }

    @PostMapping("/signup")
    public String signUp(@Valid CreateUser createUser, BindingResult result,Model m){
        if(result.hasErrors()){
            m.addAttribute("createUser",createUser);
            return "signUpView";
        }else{
            userService.register(createUser);
            return "redirect:/signin";
        }
    }
    @GetMapping("/edit/{mail}")
    public String updateContactForm(Model model,Principal p, @PathVariable(value="mail") String mail){
        User user = userService.getUserByMail(mail);
        model.addAttribute("updateUser", user);
        if(p.getName().equals("laurence.rosa@rosa-formation.fr")){
            model.addAttribute("list","true");
        }
        return "editUser";
    }

    @PostMapping("/edit")
    public String editContactForm(@Valid UpdateUser updateUser, BindingResult result, Model m){
        if(result.hasErrors()){
            m.addAttribute("updateUser",updateUser);
            return "editUser";
        }else{
            userService.update(updateUser);
            return "redirect:/signin";
        }
    }

    @GetMapping("/details/user")
    public String displayDetailForm(Model m, Principal p){
        m.addAttribute("command",new CreateUser());

        if(p.getName().equals("laurence.rosa@rosa-formation.fr")  ){
            m.addAttribute("list","true");
        }
        List<User> userList= userService.getAllUser();
        m.addAttribute("users",userList);
        return "detailUser";
    }


    @PostMapping("/delete/user")
    public String delete(Principal p){
        userService.deleteUser(p.getName());
        return "redirect:/signin";
    }

    @GetMapping("/delete/user/{mail}")
    public String deleteUser(@PathVariable(value="mail") String mail){
        userService.deleteUser(mail);
        return "redirect:/details/user";
    }
}
