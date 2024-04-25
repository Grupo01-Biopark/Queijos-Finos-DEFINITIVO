package com.example.demo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


public class DocumentController {
    
}

@GetMapping("/cadastro")
public ModelAndView seuMetodo() {
    User user = new User();
    
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("cadastroUsuario"); // Define o nome da visualização que você deseja retornar
    modelAndView.addObject("user", user);
    // Adicionar a lista de usuários ao modelo
    modelAndView.addObject("users", getAllUsers());

    return modelAndView;
}

@PostMapping("/cadastro/usuario")
public RedirectView createUser(@ModelAttribute("user") User user, RedirectAttributes attributes) {
    try {
        userService.creatUser(user);
        attributes.addFlashAttribute("condition", "condition");
    } catch (DataIntegrityViolationException e) {
        attributes.addFlashAttribute("mensagem", "Email ja cadastardo no sistema "+e.getMessage());
    }
    return new RedirectView("/cadastro");
}
