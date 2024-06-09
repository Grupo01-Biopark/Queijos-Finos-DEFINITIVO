package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.dtos.ProducerFilterDto;
import com.example.demo.service.ProducerService;
import com.example.demo.service.TechnologyService;

@Controller
public class ProducerListController {

    private final ProducerService producerService;
    private final TechnologyService technologyService;

    public ProducerListController(ProducerService producerService, TechnologyService technologyService) {
        this.producerService = producerService;
        this.technologyService = technologyService;
    }

    @GetMapping("/producers")
    public ModelAndView listProducersView(@ModelAttribute("producerFilterDto") ProducerFilterDto producerFilterDto) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("producer/producers");
        modelAndView.addObject("technologies", technologyService.getListTechnology());
        modelAndView.addObject("producerFilterDto", new ProducerFilterDto());
        modelAndView.addObject("producers", producerService.getProducerInfo());
        return modelAndView;
    }

    @GetMapping("/filterProducer")
    public RedirectView filterProducerView(@ModelAttribute("producerFilterDto") ProducerFilterDto producerFilterDto,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("isFilter", "true");
        redirectAttributes.addFlashAttribute("producersFilter", producerService.getProducerInfoFilter(producerFilterDto));

        return new RedirectView("/producer");
    }

}
