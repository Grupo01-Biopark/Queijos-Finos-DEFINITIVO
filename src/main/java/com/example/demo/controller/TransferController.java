package com.example.demo.controller;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.example.demo.entity.Transfer;




@RestController
public class TransferController {



    @GetMapping("/transfer")
    public ModelAndView showscreen(){
        Transfer transfer = new Transfer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gerenciamentoTransferencias");
        modelAndView.addObject("transfer", transfer);

        return modelAndView;
    }

     @PostMapping("/transfer/register")
    public RedirectView registerTransfer(@ModelAttribute("transfer") Transfer transfer, RedirectAttributes attributes) {
        try {
            System.out.println("Hello World");
            // technologyService.createTechnology(technology);
            attributes.addFlashAttribute("condition", "condition");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("mensagem", "Erro ao cadastrar tecnologia: " + e.getMessage());
        }
        return new RedirectView("/transfer");
    }

    
}
