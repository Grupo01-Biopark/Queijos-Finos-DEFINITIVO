package com.example.demo.repository;

import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.dtos.ProducerFilterDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/* TUDO QUE ESTIVER COMMITADADO ESTA SENDO UTILIZADO EM OUTRA VERSÃO */

@Repository
public class ProducerRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getProducerInfo() {
        List<Object[]> results = entityManager.createQuery(
                "SELECT p.id, p.name, p.expirationDate, p.status " +
                        "FROM Producer p")
                .getResultList();

        List<Map<String, Object>> producerInfoList = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> producerInfo = new HashMap<>();
            producerInfo.put("id", result[0]);
            producerInfo.put("nameProducer", result[1]);
            producerInfo.put("expirationDate", result[2] != null ? result[2] : "Sem contrato ativo");
            producerInfo.put("status", result[3]);
            producerInfoList.add(producerInfo);
        }
        return producerInfoList;
    }
   

    public List<Map<String, Object>> getProducerInfoFilter(ProducerFilterDto producerFilterDto) {
        StringBuilder jpqlBuilder = new StringBuilder();
        jpqlBuilder.append("SELECT p.id, p.name, p.expirationDate, p.status ")
                   .append("FROM Producer p ")
                   .append("INNER JOIN p.address a ");
        
        if (producerFilterDto.getTechnologyName() != null && !producerFilterDto.getTechnologyName().isEmpty()) {
            jpqlBuilder.append("INNER JOIN p.transfers tr ")
                       .append("INNER JOIN tr.technology t ");
        }
        
        jpqlBuilder.append("WHERE 1=1 ");
        
        if (producerFilterDto.getNameProducer() != null && !producerFilterDto.getNameProducer().isEmpty()) {
            jpqlBuilder.append("AND LOWER(p.name) LIKE LOWER(:name) ");
        }
    
        if (producerFilterDto.getCity() != null && !producerFilterDto.getCity().isEmpty()) {
            jpqlBuilder.append("AND LOWER(a.city) LIKE LOWER(:city) ");
        }
    
        if (producerFilterDto.getTipoStatusProduction() != null) {
            jpqlBuilder.append("AND p.status = :status ");
        }
        
        if (producerFilterDto.getTechnologyName() != null && !producerFilterDto.getTechnologyName().isEmpty()) {
            jpqlBuilder.append("AND t.name = :technologyName ");
        }
        
        TypedQuery<Object[]> query = entityManager.createQuery(jpqlBuilder.toString(), Object[].class);
        
        if (producerFilterDto.getNameProducer() != null && !producerFilterDto.getNameProducer().isEmpty()) {
            query.setParameter("name", "%" + producerFilterDto.getNameProducer() + "%");
        }
        
        if (producerFilterDto.getCity() != null && !producerFilterDto.getCity().isEmpty()) {
            query.setParameter("city", "%" + producerFilterDto.getCity() + "%");
        }
        
        if (producerFilterDto.getTipoStatusProduction() != null) {
            query.setParameter("tipoStatusProduction", producerFilterDto.getTipoStatusProduction());
        }
        
        if (producerFilterDto.getTechnologyName() != null && !producerFilterDto.getTechnologyName().isEmpty()) {
            query.setParameter("technologyName", producerFilterDto.getTechnologyName());
        }
        
        List<Object[]> results = query.getResultList();
        
        List<Map<String, Object>> producerInfoList = new ArrayList<>();
        for (Object[] result : results) {
            Map<String, Object> producerInfo = new HashMap<>();
            producerInfo.put("id", result[0]);
            producerInfo.put("nameProducer", result[1]);
            producerInfo.put("expirationDate", result[2] != null ? result[2] : "Sem contrato ativo");
            producerInfo.put("status", result[3]);
            producerInfoList.add(producerInfo);
        }
        return producerInfoList;
    }
    
}