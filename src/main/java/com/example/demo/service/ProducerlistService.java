package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProducerFilterDto;
import com.example.demo.repository.ProducerRepositoryCustom;

@Service
public class ProducerlistService {

    private final ProducerRepositoryCustom producerRepositoryCustom;

    public ProducerlistService(ProducerRepositoryCustom producerRepositoryCustom) {
        this.producerRepositoryCustom = producerRepositoryCustom;
    }

    public List<Map<String, Object>> getProducerInfo() {
        return producerRepositoryCustom.getProducerInfo();
    }

    public  List<Map<String, Object>> getProducerInfoFilter(ProducerFilterDto producerFilterDto){
        return producerRepositoryCustom.getProducerInfoFilter(producerFilterDto);
    }


}
