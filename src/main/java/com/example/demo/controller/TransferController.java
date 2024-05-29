package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Transfer;
import com.example.demo.service.TechnologyService;
import com.example.demo.service.TransferService;

@RestController
public class TransferController {

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private TransferService transferService;

    @GetMapping("/transfer")
    public ModelAndView showScreen() {
        Transfer transfer = new Transfer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("gerenciamentoTransferencias");
        modelAndView.addObject("transfer", transfer);
        modelAndView.addObject("technologies", technologyService.getListTechnology());
        modelAndView.addObject("transfers", transferService.getAllTransfers());
        return modelAndView;
    }

    @GetMapping("/transfer/edit/{id}")
    public ModelAndView editTransfer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("gerenciamentoTransferencias");
        Transfer transfer = transferService.getTransferById(id);
        modelAndView.addObject("transfer", transfer);
        modelAndView.addObject("technologies", technologyService.getListTechnology());
        modelAndView.addObject("transfers", transferService.getAllTransfers());
        return modelAndView;
    }

    @PostMapping("/transfer/updateTransfer")
    public RedirectView updateTransfer(@ModelAttribute("transfer") Transfer transfer, RedirectAttributes attributes) {
        try {
            transferService.updateTransfer(transfer);
            attributes.addFlashAttribute("condition", "true");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("mensagem", "Email já cadastrado no sistema: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            attributes.addFlashAttribute("mensagem", "Erro: " + e.getMessage());
        }
        return new RedirectView("/transfer");
    }

    @PostMapping("/transfer/register")
    public ModelAndView registerTransfer(@ModelAttribute Transfer transfer) {
        transferService.createTransfer(transfer);
        return new ModelAndView("redirect:/transfer");
    }
}
