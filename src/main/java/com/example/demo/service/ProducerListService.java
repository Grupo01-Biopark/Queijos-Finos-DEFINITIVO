package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProducerFilterDto;
import com.example.demo.repository.ProducerRepositoryCustom;

@Service
public class ProducerListService {

    private final ProducerRepositoryCustom producerRepositoryCustom;

    public ProducerListService(ProducerRepositoryCustom producerRepositoryCustom) {
        this.producerRepositoryCustom = producerRepositoryCustom;
    }

    public List<Map<String, Object>> getProducerInfo() {
        List<Map<String, Object>> producerInfoList = producerRepositoryCustom.getProducerInfo();
        
        for (Map<String, Object> producerInfo : producerInfoList) {
            boolean contractExpiryWithin30Days = checkContractExpiry(producerInfo);
            System.out.println("teste supremo" + contractExpiryWithin30Days);
            if (contractExpiryWithin30Days) {
                producerInfo.put("expirationDate", "próximo ao vencimento");
                producerInfo.put("class", "expiry");
            }else{
                producerInfo.put("expirationDate", "contrato ativo");
                producerInfo.put("class", "active");
            }
        }
    
        return producerInfoList;
    }
    
    public List<Map<String, Object>> getProducerInfoFilter(ProducerFilterDto producerFilterDto){

        List<Map<String, Object>> producerInfoList = producerRepositoryCustom.getProducerInfoFilter(producerFilterDto);
        
        for (Map<String, Object> producerInfo : producerInfoList) {
            boolean contractExpiryWithin30Days = checkContractExpiry(producerInfo);
            System.out.println("teste supremo" + contractExpiryWithin30Days);
            if (contractExpiryWithin30Days) {
                producerInfo.put("expirationDate", "próximo ao vencimento");
                producerInfo.put("class", "expiry");
            }else{
                producerInfo.put("expirationDate", "contrato ativo");
                producerInfo.put("class", "active");
            }
        }
    
        return producerInfoList;
    }

    public boolean checkContractExpiry(Map<String, Object> producerInfo) {
        Object expirationDateObj = producerInfo.get("expirationDate"); 
    
        try {
            LocalDate expirationDate = LocalDate.parse(expirationDateObj.toString());
            LocalDate currentDate = LocalDate.now();
      
            long differenceInDays = ChronoUnit.DAYS.between(currentDate, expirationDate);
            System.out.println("differença em dias " + differenceInDays);
            
            return differenceInDays >= 0 && differenceInDays <= 30;
        } catch (DateTimeParseException e) {
            // Handle invalid date format
            e.printStackTrace();
            return false;
        }
    }
    
}
