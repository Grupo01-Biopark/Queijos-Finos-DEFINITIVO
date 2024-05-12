package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.repository.TransferRepository;
import com.example.demo.service.TransferService;

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

        List<Long> counts = transferService.countAllTipoStatusProductions();
        dashboardProducer.addObject("counts", counts);

        return dashboardProducer; 
    }

}
