package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.enums.TipoStatusProduction;
import com.example.demo.repository.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;


    public long countProducing() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.PRODUCING);
    }

    public long countComplementation() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.COMPLEMENTATION);
    }

    public long countWithdrawal() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.WITHDRAWAL);
    }

    public long countDisconnected() {
        return transferRepository.countByTipoStatusProduction(TipoStatusProduction.DISCONNECTED);
    }
}

