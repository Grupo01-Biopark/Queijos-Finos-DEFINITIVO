package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dtos.ProducerDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.entity.Producer;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class ProducerController {

    @Autowired
    private ProducerRepository producerRepository;

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/formularioProdutor")
    public ModelAndView seuMetodo() {
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formularioProdutor");
        modelAndView.addObject("producer", producer);
        return modelAndView;
    }

    @PostMapping("/formularioProdutor/produtor")
    public RedirectView createProducer(@ModelAttribute ProducerDto producerDTO) {
        try {
            Producer producer = new Producer();
            Address address = new Address();
            PhoneNumber phone1 = new PhoneNumber();
            PhoneNumber phone2 = new PhoneNumber();

            producer.setNome(producerDTO.getNome());
            producer.setCpf(producerDTO.getCpf());
            producer.setCnpj(producerDTO.getCnpj());
            producer.setRazaoSocial(producerDTO.getRazaoSocial());
            producer.setEmail(producerDTO.getEmail());
            producer.setDataAssinatura(producerDTO.getDataAssinatura());
            producer.setDataVencimento(producerDTO.getDataVencimento());
            producer.setSituacao(producerDTO.getSituacao());
            producer.setDataSituacao(producerDTO.getDataSituacao());
            producer.setSim_poa(producerDTO.getSim_poa());
            producer.setSusaf(producerDTO.getSusaf());
            producer.setSisbi(producerDTO.getSisbi());
            producer.setSelo_arte(producerDTO.getSelo_arte());
            producer.setCif(producerDTO.getCif());

            address.setLogradouro(producerDTO.getLogradouro());
            address.setBairro(producerDTO.getBairro());
            address.setUf(producerDTO.getUf());
            address.setCep(producerDTO.getCep());
            address.setCidade(producerDTO.getCidade());
            address.setProducer(producer);

            System.out.println(producerDTO.getTelefone1());
            System.out.println(producerDTO.getTelefone2());
            phone1.setPhone(producerDTO.getTelefone1());
            phone2.setPhone(producerDTO.getTelefone2());
            phone1.setProducer(producer);
            phone2.setProducer(producer);

            List<PhoneNumber> telefones = new ArrayList<>();
            telefones.add(phone1);
            telefones.add(phone2);

            producer.setPhoneNumbers(telefones);
            producer.setAddress(address);
            producerService.addProducer(producer);


        } catch (DataIntegrityViolationException e) {
            System.out.println("erro");
        }
        return new RedirectView("/formularioProdutor");
    }

//    public List<Producer> getAllProducers() {
//        List<Producer> producers = producerService.getListProducer();
//        return producers;
//    }

//    @DeleteMapping("/producer/{producerId}")
//    public ResponseEntity<Void> deleteProducer(@PathVariable Long producerId) {
//        producerService.deleteProducer(producerId);
//        return ResponseEntity.ok().build();
//    }

}
