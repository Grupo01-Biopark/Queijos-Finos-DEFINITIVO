package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/Login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login/Login");
        return mv; 
    }

    @PostMapping("/logInto")
    public String logar(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = repository.findByEmailAndPassword(email, password);

        if (user != null) {
            return "redirect:/home";
        }

        return "redirect:/erro";
    }
}


