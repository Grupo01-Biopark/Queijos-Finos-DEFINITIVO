package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.enums.TipoStatusProduction;
import com.example.demo.repository.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;


    public long countStatusProducing() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.PRODUCING);
    }

    public long countStatusComplementation() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.COMPLEMENTATION);
    }

    public long countStatusWithdrawal() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.WITHDRAWAL);
    }

    public long countStatusDisconnected() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.DISCONNECTED);
    }

    
    public long countProducingByTechnology(String technologyName) {
        return transferRepository.countByTechnologyNameAndTipoStatusProduction(technologyName, TipoStatusProduction.PRODUCING);
    }

    public long countComplementationByTechnology(String technologyName) {
        return transferRepository.countByTechnologyNameAndTipoStatusProduction(technologyName, TipoStatusProduction.COMPLEMENTATION);
    }

    public long countWithdrawalByTechnology(String technologyName) {
        return transferRepository.countByTechnologyNameAndTipoStatusProduction(technologyName, TipoStatusProduction.WITHDRAWAL);
    }

    public long countDisconnectedByTechnology(String technologyName) {
        return transferRepository.countByTechnologyNameAndTipoStatusProduction(technologyName, TipoStatusProduction.DISCONNECTED);
    }
}

