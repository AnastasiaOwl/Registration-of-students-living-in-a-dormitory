package com.example.kursova.controllers;

import com.example.kursova.dataAO.RoleRepository;
import com.example.kursova.dataAO.UserService;
import com.example.kursova.entities.Role;
import com.example.kursova.entities.User;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.kursova.dto.UserDto;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@org.springframework.stereotype.Controller
@AllArgsConstructor
public class RegisterController {
    private RoleRepository roleRepository;
    private UserService userService;
    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        List<Role> allRoles = roleRepository.findAll();
        model.addAttribute("allRoles", allRoles);
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    @GetMapping("/main_page")
    public String mainPage() {
        return "main_page";
    }
}

