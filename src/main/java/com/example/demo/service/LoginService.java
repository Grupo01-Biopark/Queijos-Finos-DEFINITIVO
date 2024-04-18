package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public String login(String email, String password) {
        System.out.println("Email recebido no serviço: " + email);
        System.out.println("Senha recebida no serviço: " + password);
        return "token";
    }

    public boolean checkLogin(String email, String password) {
        System.out.println("Email recebido no serviço para verificação: " + email);
        System.out.println("Senha recebida no serviço para verificação: " + password);
        return false;
    }
}

