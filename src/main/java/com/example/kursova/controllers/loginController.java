package com.example.kursova.controllers;

import com.example.kursova.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.kursova.dataAO.UserService;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class loginController {

    private final UserService userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/submit")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        User user = userService.findUserByEmail(username);
        System.out.println("works");

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // If login is successful, add a redirect attribute
            redirectAttributes.addFlashAttribute("redirect", true);
            System.out.println("Redirect attribute set!");
            return "redirect:/main_page";
        } else {
            // If login fails, you might want to add an error message or handle it accordingly
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }
    }
}

