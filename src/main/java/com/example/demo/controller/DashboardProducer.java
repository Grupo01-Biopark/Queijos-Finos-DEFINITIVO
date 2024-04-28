package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardProducer {
    
    @GetMapping("/dashboardProducer")
    public ModelAndView dashboardProducer() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("producerDashboards/producerDashboards");
        return mv; 
    }

    

}
