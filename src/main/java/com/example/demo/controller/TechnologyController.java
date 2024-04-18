package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Technology;
import com.example.demo.service.TechnologyService;



@RestController
public class TechnologyController {
    
    @Autowired
    private TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }


    @GetMapping("/tecnologias")
    public ModelAndView iniciarTela() {
        Technology technology = new Technology();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gerenciamentoTecnologias");
        modelAndView.addObject("technology", technology);
        modelAndView.addObject("users", getAllTechnologies());
        

        return modelAndView;
    }

    @PostMapping("/tecnologias/cadastrar")
    public RedirectView createTechnology(@ModelAttribute("technology") Technology technology, RedirectAttributes attributes) {
        try {
            technologyService.createTechnology(technology);
            attributes.addFlashAttribute("mensagem", "Tecnologia cadastrada com sucesso");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("mensagem", "Erro ao cadastrar tecnologia: " + e.getMessage());
        }
        return new RedirectView("/tecnologias");
    }

    public List<Technology> getAllTechnologies() {
        List<Technology> technologies = TechnologyService.getListTechnology();
        return technologies;
    }

  
}