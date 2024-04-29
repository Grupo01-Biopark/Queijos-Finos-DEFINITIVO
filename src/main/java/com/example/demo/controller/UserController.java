package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

   
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

    
    public List<User> getAllUsers() {
        List<User> users = userService.getListUser();
        return users;
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/users/updateUser")
    public RedirectView updateUser(@ModelAttribute("user") User user , RedirectAttributes attributes) {

        System.out.println("o id do usuario e:" + user.getId());
        System.out.println("o nome do usuaruio e:" + user.getNameUser());
        try {
            userService.updateUser(user);
            attributes.addFlashAttribute("condition", "condition");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("mensagem", "Email ja cadastardo no sistema "+e.getMessage());
        }

        return new RedirectView("/cadastro");
    }
}
