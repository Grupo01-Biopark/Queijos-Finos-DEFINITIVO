package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.DTO.TransferStatusProductionDTO;
import com.example.demo.repository.TransferRepository;
import com.example.demo.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DashboardProducer {
    
    @Autowired
    TransferService transferService;

    @Autowired
    TransferRepository transferRepository;

    @GetMapping("/dashboardProducer")
    public ModelAndView dashboardProducer() {
        ModelAndView dashboardProducer = new ModelAndView();
        dashboardProducer.setViewName("producerDashboards/producerDashboards");
        return dashboardProducer; 
    }

    @PostMapping("/dashboardProducer")
    public ModelAndView statusProduction() {
        ModelAndView dashboardProducer = new ModelAndView();
        
        
        TransferStatusProductionDTO statusCounts = transferService.getStatusCounts();
        //log de verficação
        System.out.println("Dados recebidos do serviçoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: " + statusCounts); // Log dos dados recebidos
        
        dashboardProducer.addObject("statusCounts", statusCounts);
        
        return dashboardProducer;
    }   
}

