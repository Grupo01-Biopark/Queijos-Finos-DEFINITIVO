package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DashboardProducerData {

    @GetMapping("/dashboardProducerDate")
    public ModelAndView viewUsersAndView() {
      
        ModelAndView modelAndView = new ModelAndView("dashboardProducerDate");
        return modelAndView;
    }

}
