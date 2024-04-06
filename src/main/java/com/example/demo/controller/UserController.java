package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;







@RestController
public class UserController {
    
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @GetMapping("/s")
    public ModelAndView seuMetodo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastroUsuario"); // Defina o nome da visualização que você deseja retornar
        
        // Obter a lista de usuários do serviço UserService
        List<User> users = userService.getListUser();
        
        // Adicionar a lista de usuários ao modelo
        modelAndView.addObject("users", users); 

        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Use o método Builder para criar uma nova instância de User
        User saveUser = new User.Builder()
                    .nameUser(user.getNameUser())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .tipoUserPermission(user.getTipoUserPermission())
                    .build();
        
        // Aqui você pode fazer algo com o usuário, como salvar no banco de dados
        userService.creatUser(saveUser);
        
        // Você pode retornar o usuário criado, se desejar
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){ 
        List<User> users = userService.getListUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    
    }

    

   

}



