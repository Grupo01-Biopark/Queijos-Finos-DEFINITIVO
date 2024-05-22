package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.example.demo.dtos.ProducerDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.entity.Producer;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ProducerController {

    @Autowired
    private ProducerRepository producerRepository;

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/formProducer")
    public ModelAndView showForm() {
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("formProducer");
        modelAndView.addObject("producer", producer);
        return modelAndView;
    }

    @GetMapping("/producers")
    public ModelAndView showProducers(){
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("producers");
        modelAndView.addObject("producer", producer);
        modelAndView.addObject("producers", getAllProducers());
        return modelAndView;
    }

    @GetMapping("/producers/{producerId}")
    public ResponseEntity<Void> deleteProducer(@PathVariable Long producerId){
        System.out.println("Delete Producer " + producerId);
        producerRepository.deleteById(producerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/editProducer/update/{producerId}")
    public RedirectView updateProducer(
            @PathVariable Long producerId,
            @ModelAttribute ProducerDto producerDto
    ){
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new NoSuchElementException("Producer not found with id: " + producerId));

        producer.setName(producerDto.getName());
        producer.setCpf(producerDto.getCpf());
        producer.setCnpj(producerDto.getCnpj());
        producer.setSocialReason(producerDto.getSocialReason());
        producer.setEmail(producerDto.getEmail());
        producer.setSignatureDate(producerDto.getSignatureDate());
        producer.setExpirationDate(producerDto.getExpirationDate());
        producer.setStatus(producerDto.getStatus());
        producer.setStatusDate(producerDto.getStatusDate());
        producer.setSimPoa(producerDto.getSimPoa());
        producer.setSusaf(producerDto.getSusaf());
        producer.setSisbi(producerDto.getSisbi());
        producer.setSeloArte(producerDto.getSeloArte());
        producer.setCif(producerDto.getCif());
        producer.setObservation(producerDto.getObservation());

        Address address = producer.getAddress();
        if (address == null) {
            address = new Address();
        }
        address.setStreet(producerDto.getStreet());
        address.setNeighborhood(producerDto.getNeighborhood());
        address.setState(producerDto.getState());
        address.setCep(producerDto.getCep());
        address.setCity(producerDto.getCity());
        address.setProducer(producer);
        producer.setAddress(address);

        List<PhoneNumber> phoneNumbers = producer.getPhoneNumbers();
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.clear();

        PhoneNumber phone1 = new PhoneNumber();
        phone1.setPhone(producerDto.getPhone1());
        phone1.setProducer(producer);
        phoneNumbers.add(phone1);

        PhoneNumber phone2 = new PhoneNumber();
        phone2.setPhone(producerDto.getPhone2());
        phone2.setProducer(producer);
        phoneNumbers.add(phone2);

        producer.setPhoneNumbers(phoneNumbers);

        producerService.updateProducer(producer);

        return new RedirectView("/editProducer/"+ producerId);
    }

    @GetMapping("/editProducer/{producerId}")
    public ModelAndView editProducer(@PathVariable Long producerId){
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new NoSuchElementException("Producer not found with id: " + producerId));
        ProducerDto producerDto = new ProducerDto();

        producerDto.setName(producer.getName());
        producerDto.setCpf(producer.getCpf());
        producerDto.setCnpj(producer.getCnpj());
        producerDto.setSocialReason(producer.getSocialReason());
        producerDto.setEmail(producer.getEmail());
        producerDto.setSignatureDate(producer.getSignatureDate());
        producerDto.setExpirationDate(producer.getExpirationDate());
        producerDto.setStatus(producer.getStatus());
        producerDto.setStatusDate(producer.getStatusDate());
        producerDto.setSimPoa(producer.getSimPoa());
        producerDto.setSusaf(producer.getSusaf());
        producerDto.setSisbi(producer.getSisbi());
        producerDto.setSeloArte(producer.getSeloArte());
        producerDto.setCif(producer.getCif());
        producerDto.setObservation(producer.getObservation());

        Address address = producer.getAddress();
        if (address != null) {
            producerDto.setStreet(address.getStreet());
            producerDto.setNeighborhood(address.getNeighborhood());
            producerDto.setState(address.getState());
            producerDto.setCep(address.getCep());
            producerDto.setCity(address.getCity());
        }

        List<PhoneNumber> phoneNumbers = producer.getPhoneNumbers();
        if (phoneNumbers != null && !phoneNumbers.isEmpty()) {
            for (int i = 0; i < phoneNumbers.size(); i++) {
                if (i == 0) {
                    producerDto.setPhone1(phoneNumbers.get(i).getPhone());
                } else if (i == 1) {
                    producerDto.setPhone2(phoneNumbers.get(i).getPhone());
                }
            }
        }

        ModelAndView model = new ModelAndView();
        model.setViewName("editProducer");
        model.addObject("producerDto", producerDto);
        model.addObject("producer", producer);

        return model;
    }

    @PostMapping("/formProducer/producer")
    public RedirectView createProducer(@ModelAttribute ProducerDto producerDto) {
        try {
            Producer producer = new Producer();
            Address address = new Address();
            PhoneNumber phone1 = new PhoneNumber();
            PhoneNumber phone2 = new PhoneNumber();

            producer.setName(producerDto.getName());
            producer.setCpf(producerDto.getCpf());
            producer.setCnpj(producerDto.getCnpj());
            producer.setSocialReason(producerDto.getSocialReason());

            producer.setEmail(producerDto.getEmail());
            producer.setSignatureDate(producerDto.getSignatureDate());
            producer.setExpirationDate(producerDto.getExpirationDate());
            producer.setStatus(producerDto.getStatus());
            producer.setStatusDate(producerDto.getStatusDate());
            producer.setSimPoa(producerDto.getSimPoa());
            producer.setSusaf(producerDto.getSusaf());
            producer.setSisbi(producerDto.getSisbi());
            producer.setSeloArte(producerDto.getSeloArte());
            producer.setCif(producerDto.getCif());

            address.setStreet(producerDto.getStreet());
            address.setNeighborhood(producerDto.getNeighborhood());
            address.setState(producerDto.getState());
            address.setCep(producerDto.getCep());
            address.setCity(producerDto.getCity());
            address.setProducer(producer);

            System.out.println(producerDto.getPhone1());
            System.out.println(producerDto.getPhone2());
            phone1.setPhone(producerDto.getPhone1());
            phone2.setPhone(producerDto.getPhone2());
            phone1.setProducer(producer);
            phone2.setProducer(producer);

            List<PhoneNumber> phones = new ArrayList<>();
            phones.add(phone1);
            phones.add(phone2);

            producer.setPhoneNumbers(phones);
            producer.setAddress(address);
            producerService.addProducer(producer);

        } catch (DataIntegrityViolationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new RedirectView("/producers");
    }

    public List<Producer> getAllProducers() {
        return producerService.getListProducers();
    }
}

