package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Transfer;
import com.example.demo.service.TechnologyService;
import com.example.demo.service.TransferService;




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
    modelAndView.addObject("transfers", transferService.getAllTransfers()); // Adicione esta linha
    return modelAndView;
}
    

     @Autowired
    private TransferService transferService;

    @PostMapping("/transfer/register")
    public ModelAndView registerTransfer(@RequestBody Transfer transfer) {
        transferService.createTransfer(transfer);
        return new ModelAndView("redirect:/transfer");
    }

    
}
