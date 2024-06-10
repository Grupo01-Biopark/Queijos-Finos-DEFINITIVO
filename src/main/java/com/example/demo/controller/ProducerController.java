package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import com.example.demo.dtos.ProducerDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Certificate;
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

    /* @GetMapping("/producers") DESATIVADO POR CONTA DE MELHORIAS
    public ModelAndView showProducers(){
        Producer producer = new Producer();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("producers");
        modelAndView.addObject("producer", producer);
        modelAndView.addObject("producers", getAllProducers());
        return modelAndView;
    }*/

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

        // Formatando as datas para o padrão esperado
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (producerDto.getSignatureDate() != null && !producerDto.getSignatureDate().isEmpty()) {
            LocalDate signatureDateParsed = LocalDate.parse(producerDto.getSignatureDate(), dateFormat);
            Date signatureDate = Date.from(signatureDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            producer.setSignatureDate(signatureDate);
        } else {
            producer.setSignatureDate(null);
        }

        if (producerDto.getExpirationDate() != null && !producerDto.getExpirationDate().isEmpty()) {
            LocalDate expirationDateParsed = LocalDate.parse(producerDto.getExpirationDate(), dateFormat);
            Date expirationDate = Date.from(expirationDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            producer.setExpirationDate(expirationDate);
        } else {
            producer.setExpirationDate(null);
        }

        if (producerDto.getStatusDate() != null && !producerDto.getStatusDate().isEmpty()) {
            LocalDate statusDateParsed = LocalDate.parse(producerDto.getStatusDate(), dateFormat);
            Date statusDate = Date.from(statusDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            producer.setStatusDate(statusDate);
        } else {
            producer.setStatusDate(null);
        }

        Certificate certificate = new Certificate();

        if (producerDto.getSimPoa() != null && !producerDto.getSimPoa().isEmpty()) {
            LocalDate simPoaDateParsed = LocalDate.parse(producerDto.getSimPoa(), dateFormat);
            Date simPoaDate = Date.from(simPoaDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            certificate.setSimPoa(simPoaDate);
        } else {
            certificate.setSimPoa(null);
        }

        if (producerDto.getSusaf() != null && !producerDto.getSusaf().isEmpty()) {
            LocalDate susafDateParsed = LocalDate.parse(producerDto.getSusaf(), dateFormat);
            Date susafDate = Date.from(susafDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            certificate.setSusaf(susafDate);
        } else {
            certificate.setSusaf(null);
        }

        if (producerDto.getSisbi() != null && !producerDto.getSisbi().isEmpty()) {
            LocalDate sisbiDateParsed = LocalDate.parse(producerDto.getSisbi(), dateFormat);
            Date sisbiDate = Date.from(sisbiDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            certificate.setSisbi(sisbiDate);
        } else {
            certificate.setSisbi(null);
        }

        if (producerDto.getSeloArte() != null && !producerDto.getSeloArte().isEmpty()) {
            LocalDate seloArteDateParsed = LocalDate.parse(producerDto.getSeloArte(), dateFormat);
            Date seloArteDate = Date.from(seloArteDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            certificate.setSeloArte(seloArteDate);
        } else {
            certificate.setSeloArte(null);
        }

        if (producerDto.getCif() != null && !producerDto.getCif().isEmpty()) {
            LocalDate cifDateParsed = LocalDate.parse(producerDto.getCif(), dateFormat);
            Date cifDate = Date.from(cifDateParsed.atStartOfDay(ZoneId.systemDefault()).toInstant());
            certificate.setCif(cifDate);
        } else {
            certificate.setCif(null);
        }

        certificate.setProducer(producer);
        producer.setCertificates(certificate);


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
        address.setNumber(producerDto.getNumber());
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
    public ModelAndView editProducer(@PathVariable Long producerId) {
        Producer producer = producerRepository.findById(producerId)
                .orElseThrow(() -> new NoSuchElementException("Producer not found with id: " + producerId));
        ProducerDto producerDto = new ProducerDto();

        producerDto.setName(producer.getName());
        producerDto.setCpf(producer.getCpf());
        producerDto.setCnpj(producer.getCnpj());
        producerDto.setSocialReason(producer.getSocialReason());
        producerDto.setEmail(producer.getEmail());

        // Formatando as datas para string
        String signatureDateStr = formatDate(producer.getSignatureDate());
        producerDto.setSignatureDate(signatureDateStr);

        String expirationDateStr = formatDate(producer.getExpirationDate());
        producerDto.setExpirationDate(expirationDateStr);

        String statusDateStr = formatDate(producer.getStatusDate());
        producerDto.setStatusDate(statusDateStr);

        String simPoaStr = formatDate(producer.getCertificates().getSimPoa());
        producerDto.setSimPoa(simPoaStr);

        String susafStr = formatDate(producer.getCertificates().getSusaf());
        producerDto.setSusaf(susafStr);

        String sisbiStr = formatDate(producer.getCertificates().getSisbi());
        producerDto.setSisbi(sisbiStr);

        String seloArteStr = formatDate(producer.getCertificates().getSeloArte());
        producerDto.setSeloArte(seloArteStr);

        String cifStr = formatDate(producer.getCertificates().getCif());
        producerDto.setCif(cifStr);

        producerDto.setObservation(producer.getObservation());

        Address address = producer.getAddress();
        if (address != null) {
            producerDto.setStreet(address.getStreet());
            producerDto.setNeighborhood(address.getNeighborhood());
            producerDto.setState(address.getState());
            producerDto.setCep(address.getCep());
            producerDto.setCity(address.getCity());
            producerDto.setNumber(address.getNumber());
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

    private String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        }
        return "";
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
            producer.setObservation(producerDto.getObservation());

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            producer.setEmail(producerDto.getEmail());

            // Parsing dates with null checks
            producer.setSignatureDate(parseDate(producerDto.getSignatureDate(), dateFormat));
            producer.setExpirationDate(parseDate(producerDto.getExpirationDate(), dateFormat));
            producer.setStatusDate(parseDate(producerDto.getStatusDate(), dateFormat));

            Certificate certificate = new Certificate();
            certificate.setSimPoa(parseDate(producerDto.getSimPoa(), dateFormat));
            certificate.setSusaf(parseDate(producerDto.getSusaf(), dateFormat));
            certificate.setSisbi(parseDate(producerDto.getSisbi(), dateFormat));
            certificate.setSeloArte(parseDate(producerDto.getSeloArte(), dateFormat));
            certificate.setCif(parseDate(producerDto.getCif(), dateFormat));
            certificate.setProducer(producer);

            address.setStreet(producerDto.getStreet());
            address.setNeighborhood(producerDto.getNeighborhood());
            address.setState(producerDto.getState());
            address.setCep(producerDto.getCep());
            address.setCity(producerDto.getCity());
            address.setProducer(producer);
            address.setNumber(producerDto.getNumber());

            phone1.setPhone(producerDto.getPhone1());
            phone2.setPhone(producerDto.getPhone2());
            phone1.setProducer(producer);
            phone2.setProducer(producer);

            List<PhoneNumber> phones = new ArrayList<>();
            phones.add(phone1);
            phones.add(phone2);

            producer.setPhoneNumbers(phones);
            producer.setAddress(address);
            producer.setCertificates(certificate);
            producerService.addProducer(producer);

        } catch (DataIntegrityViolationException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new RedirectView("/producers");
    }

    private java.sql.Date parseDate(String dateString, DateTimeFormatter dateFormat) {
        if (dateString != null && !dateString.isEmpty()) {
            LocalDate date = LocalDate.parse(dateString, dateFormat);
            return java.sql.Date.valueOf(date);
        }
        return null;
    }

    public List<Producer> getAllProducers() {
        return producerService.getListProducers();
    }
}

