//package com.example.demo.controller;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import com.example.demo.service.TechnologyService;
//import com.example.demo.service.TransferService;
//
//@RestController
//public class DashboardProducer {
//
//    @Autowired
//    TransferService transferService;
//    @Autowired
//    TechnologyService technologyService;
//
//    @GetMapping("/dashboardProducer")
//    public ModelAndView dashboardProducer() {
//        ModelAndView dashboardProducer = new ModelAndView();
//        dashboardProducer.setViewName("producerDashboards/producerDashboards");
//
//        //METODO DE CONSULTA PARA O PRIMEIRO GRAFICO
//        long producingCount = transferService.countStatusProducing();
//        long complementationCount = transferService.countStatusComplementation();
//        long withdrawalCount = transferService.countStatusWithdrawal();
//        long disconnectedCount = transferService.countStatusDisconnected();
//        dashboardProducer.addObject("producingCount", producingCount);
//        dashboardProducer.addObject("complementationCount", complementationCount);
//        dashboardProducer.addObject("withdrawalCount", withdrawalCount);
//        dashboardProducer.addObject("disconnectedCount", disconnectedCount);
//
//
//        //METODO DE CONSULTA PARA O SEGUNDO GRAFICO
//        List<String> activeTechnologyNames = technologyService.getAllActiveTechnologyNames();
//        List<Long> producingCounts = activeTechnologyNames.stream()
//                .map(transferService::countProducingByTechnology)
//                .collect(Collectors.toList());
//        List<Long> complementationCounts = activeTechnologyNames.stream()
//                .map(transferService::countComplementationByTechnology)
//                .collect(Collectors.toList());
//        List<Long> withdrawalCounts = activeTechnologyNames.stream()
//                .map(transferService::countWithdrawalByTechnology)
//                .collect(Collectors.toList());
//        List<Long> disconnectedCounts = activeTechnologyNames.stream()
//                .map(transferService::countDisconnectedByTechnology)
//                .collect(Collectors.toList());
//
//        dashboardProducer.addObject("activeTechnologyNames", activeTechnologyNames);
//        dashboardProducer.addObject("producingCounts", producingCounts);
//        dashboardProducer.addObject("complementationCounts", complementationCounts);
//        dashboardProducer.addObject("withdrawalCounts", withdrawalCounts);
//        dashboardProducer.addObject("disconnectedCounts", disconnectedCounts);
//
//        return dashboardProducer;
//    }
//}
//
//
