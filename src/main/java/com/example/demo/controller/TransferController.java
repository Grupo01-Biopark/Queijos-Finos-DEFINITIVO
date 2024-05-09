package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Transfer;
import com.example.demo.service.TechnologyService;




@RestController
public class TransferController {

    @Autowired
    TechnologyService technologyService;

    @GetMapping("/transfer")
    public ModelAndView showscreen() {
        Transfer transfer = new Transfer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gerenciamentoTransferencias");
        modelAndView.addObject("transfer", transfer);
        modelAndView.addObject("technologies", technologyService.getListTechnology());
        return modelAndView;
    }
    

    //  @PostMapping("/transfer/register")
    // public RedirectView registerTransfer(@ModelAttribute("transfer") Transfer transfer, RedirectAttributes attributes) {
    //     try {
    //         System.out.println("Hello World");
    //         // technologyService.createTechnology(technology);
    //         attributes.addFlashAttribute("condition", "condition");
    //     } catch (DataIntegrityViolationException e) {
    //         attributes.addFlashAttribute("mensagem", "Erro ao cadastrar tecnologia: " + e.getMessage());
    //     }
    //     return new RedirectView("/transfer");
    // }

    
}
