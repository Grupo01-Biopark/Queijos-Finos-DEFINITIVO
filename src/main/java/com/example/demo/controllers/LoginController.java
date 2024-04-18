package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
    private LoginService loginService;	
	
	@GetMapping("/Login")
	public ModelAndView Login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/Login");
		return mv;
	}
	
	@PostMapping("/login")
public String login(@RequestParam("email") String email,
                    @RequestParam("password") String password,
                    RedirectAttributes redirectAttributes) {
    System.out.println("Email recebido no controller: " + email);
    System.out.println("Senha recebida no controller: " + password);
    boolean loginSuccessful = loginService.checkLogin(email, password);
    if (loginSuccessful) {
        return "redirect:/home"; 
    } else {
        redirectAttributes.addFlashAttribute("error", "Credenciais inválidas. Por favor, tente novamente.");
        return "redirect:/PasswordReset"; 
    }
}

	
	
}
