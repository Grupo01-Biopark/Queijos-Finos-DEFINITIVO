package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Certificate;
import com.example.demo.entity.PhoneNumber;
import com.example.demo.entity.Producer;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PhoneNumberRepository;
import com.example.demo.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public Producer addProducer(Producer producer) {
        producerRepository.save(producer);
        for (int i =0; i < 2; i = i + 1){
            List<PhoneNumber> telefones = new ArrayList<PhoneNumber>(producer.getPhoneNumbers());
            phoneNumberRepository.save(telefones.get(i));
        };

        addressRepository.save(producer.getAddress());

        System.out.println("salvo com sucesso");
        return producerRepository.save(producer);
    }
}