package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.TechnologyService;
import com.example.demo.service.TransferService;

@Controller
public class DashboardProducer {

    @Autowired
    TransferService transferService;
    @Autowired
    TechnologyService technologyService;

    @GetMapping("/dashboardProducer")
    public ModelAndView dashboardProducer() {
        ModelAndView dashboardProducer = new ModelAndView();
        dashboardProducer.setViewName("producerDashboards/producerDashboards");
        
        dashboardProducer.addObject("producingCount", transferService.countProducing());
        dashboardProducer.addObject("complementationCount", transferService.countComplementation());
        dashboardProducer.addObject("withdrawalCount", transferService.countWithdrawal());
        dashboardProducer.addObject("disconnectedCount", transferService.countDisconnected());
        dashboardProducer.addObject("result", technologyService.generateReportForAllTechnologiesAsJson());

        System.out.println(technologyService.generateReportForAllTechnologiesAsJson());

        return dashboardProducer;
    }
}

