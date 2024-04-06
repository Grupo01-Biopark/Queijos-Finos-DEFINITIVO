package com.example.demo.service;



import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import jakarta.validation.Valid;


@Service
public class UserService {
   
    @Autowired
    private UserRepository userRepository;

    @Validated
    public User creatUser(@Valid User user) {
        Objects.requireNonNull(user, "Usuário inválido. Verifique os campos obrigatórios.");
        return userRepository.save(user);
    }

   public List <User> getListUser(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("Nenhum usuário cadastrado."); 
        }
        return users;
    }

    public Optional<User> getUserById(Long id) {
        
        Objects.requireNonNull(id, "id invalido");
        Optional <User> user =  userRepository.findById(id);
       
        return user;
    }

    

}

