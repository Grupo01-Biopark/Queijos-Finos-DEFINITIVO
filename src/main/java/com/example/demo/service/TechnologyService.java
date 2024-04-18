package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Technology;
import com.example.demo.repository.TechnologyRepository;

import jakarta.validation.Valid;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Validated
    public Technology createTechnology(@Valid Technology technology) {
        Objects.requireNonNull(technology, "Tecnologia inválida. Verifique os campos obrigatórios.");
        return technologyRepository.save(technology);
    }

    public List <Technology> getListTechnology(){
        List<Technology> technologies = technologyRepository.findAll();
        return technologies != null ? technologies : Collections.emptyList();
    }

    public void deleteTechnology(Long technologyId) {
        technologyRepository.deleteById(technologyId);
    }

}
