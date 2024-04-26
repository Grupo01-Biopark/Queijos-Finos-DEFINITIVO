package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordResetController {
    
    @GetMapping("PasswordReset/PasswordReset.html")
    public ModelAndView PasswordReset() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("PasswordReset/PasswordReset");
        return mv; 
    }

}
