package com.example.demo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Technology;
import com.example.demo.entity.enums.TipoStatusProduction;
import com.example.demo.repository.TechnologyRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.Valid;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private EntityManager entityManager;

    @Validated
    public Technology createTechnology(@Valid Technology technology) {
        Objects.requireNonNull(technology, "Tecnologia inválida. Verifique os campos obrigatórios.");
        return technologyRepository.save(technology);
    }

    @Validated
    public Technology alterTechnology(@Valid Technology technology) {

        Objects.requireNonNull(technology, "Tecnologia inválida. Verifique os campos obrigatórios.");

        Optional<Technology> existingTechnologyOptional = technologyRepository.findById(technology.getId());

        if (existingTechnologyOptional.isPresent()) {

            Technology existingTechnology = existingTechnologyOptional.get();

            existingTechnology.setName(technology.getName());

            return technologyRepository.save(existingTechnology);
        } else {

            throw new IllegalArgumentException("Tecnologia não encontrada.");
        }
    }

    public List<Technology> getListTechnology() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies != null ? technologies : Collections.emptyList();
    }

    public void deleteTechnology(Long technologyId) {
        technologyRepository.deleteById(technologyId);
    }

    public Map<String, Map<String, Long>> generateReportForAllTechnologies() {

        Query query = entityManager.createNativeQuery(
                "SELECT t.name, tt.tipo_status_production, COUNT(*) " +
                        "FROM tb_technology t " +
                        "LEFT JOIN tb_transfer tt ON t.id = tt.technology_id " +
                        "GROUP BY t.name, tt.tipo_status_production");

        List<Object[]> results = query.getResultList();

        Map<String, Map<String, Long>> report = new HashMap<>();
        for (Object[] row : results) {
            String technologyName = (String) row[0];
            Byte statusByte = (Byte) row[1];
            TipoStatusProduction status = (statusByte != null) ? TipoStatusProduction.values()[statusByte] : null;
            String statusName = (status != null) ? status.name() : null;
            Long count = ((Number) row[2]).longValue(); // Cast para Long

            if (!report.containsKey(technologyName)) {
                report.put(technologyName, new HashMap<>());
            }
            report.get(technologyName).put(statusName, count);
        }

        return report;
    }

}
