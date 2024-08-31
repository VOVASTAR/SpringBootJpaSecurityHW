package edu.hillel.SpringBootJpaSecurityHW.controller;

import edu.hillel.SpringBootJpaSecurityHW.entity.User;
import edu.hillel.SpringBootJpaSecurityHW.repo.UserRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    public final UserRepositoryJpa userRepositoryJpa;
    public final PasswordEncoder passwordEncoder;

    @GetMapping
    public String getRegistrationForm(@ModelAttribute User user) {
        return "registrationForm";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.CLIENT);
        userRepositoryJpa.save(user);
        return "redirect:/orders/get-all";
    }
}
