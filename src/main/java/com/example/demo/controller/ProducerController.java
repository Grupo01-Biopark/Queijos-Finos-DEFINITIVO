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
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.naming.Binding;


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

    @GetMapping("/produtores")
    public ModelAndView seuMetodo2(){
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("produtores");
        modelAndView.addObject("producer", producer);
        modelAndView.addObject("producers", getAllProducers());
        return modelAndView;
    }

    @GetMapping("/produtores/{producerId}")
    public ResponseEntity<Void> deleteProducer(@PathVariable Long producerId){
        System.out.println("Deletar Produtor" + producerId);
        producerRepository.deleteById(producerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/editProdutor/atualizar/{producerId}")
    public RedirectView atualizarProducer(
            @PathVariable Long producerId,
            @ModelAttribute ProducerDto producerDTO
    ){

        Producer producer = producerRepository.findById(producerId).get();

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
        producer.setObservacao(producerDTO.getObservacao());

        Address address = producer.getAddress();
        if (address == null) {
            address = new Address();
        }
        address.setLogradouro(producerDTO.getLogradouro());
        address.setBairro(producerDTO.getBairro());
        address.setUf(producerDTO.getUf());
        address.setCep(producerDTO.getCep());
        address.setCidade(producerDTO.getCidade());
        address.setProducer(producer);
        producer.setAddress(address);

        List<PhoneNumber> phoneNumbers = producer.getPhoneNumbers();
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.clear();

        PhoneNumber phone1 = new PhoneNumber();
        phone1.setPhone(producerDTO.getTelefone1());
        phone1.setProducer(producer);
        phoneNumbers.add(phone1);

        PhoneNumber phone2 = new PhoneNumber();
        phone2.setPhone(producerDTO.getTelefone2());
        phone2.setProducer(producer);
        phoneNumbers.add(phone2);

        producer.setPhoneNumbers(phoneNumbers);

        producerService.updateProducer(producer);

        return new RedirectView("/editProdutor/"+ producerId);
    }


    @GetMapping("/editProdutor/{producerId}")
    public ModelAndView metodo(@PathVariable Long producerId){
        Producer producer = producerRepository.findById(producerId).get();
        ProducerDto producerDTO = new ProducerDto();

        producerDTO.setNome(producer.getNome());
        producerDTO.setCpf(producer.getCpf());
        producerDTO.setCnpj(producer.getCnpj());
        producerDTO.setRazaoSocial(producer.getRazaoSocial());
        producerDTO.setEmail(producer.getEmail());
        producerDTO.setDataAssinatura(producer.getDataAssinatura());
        producerDTO.setDataVencimento(producer.getDataVencimento());
        producerDTO.setSituacao(producer.getSituacao());
        producerDTO.setDataSituacao(producer.getDataSituacao());
        producerDTO.setSim_poa(producer.getSim_poa());
        producerDTO.setSusaf(producer.getSusaf());
        producerDTO.setSisbi(producer.getSisbi());
        producerDTO.setSelo_arte(producer.getSelo_arte());
        producerDTO.setCif(producer.getCif());
        producerDTO.setObservacao(producer.getObservacao());

        Address address = producer.getAddress();
        if (address != null) {
            producerDTO.setLogradouro(address.getLogradouro());
            producerDTO.setBairro(address.getBairro());
            producerDTO.setUf(address.getUf());
            producerDTO.setCep(address.getCep());
            producerDTO.setCidade(address.getCidade());
        }

        List<PhoneNumber> phoneNumbers = producer.getPhoneNumbers();
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            for (int i = 0; i < phoneNumbers.size(); i++) {
                if (i == 0) {
                    producerDTO.setTelefone1(phoneNumbers.get(i).getPhone());
                } else if (i == 1) {
                    producerDTO.setTelefone2(phoneNumbers.get(i).getPhone());
                }
            }
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("editProdutor");
        model.addObject("producerDto", producerDTO);
        model.addObject("producer", producer);

        return model;
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
        return new RedirectView("/produtores");
    }

    public List<Producer> getAllProducers() {
        List<Producer> producers = producerService.getListProducers();
        return producers;
    }
}
