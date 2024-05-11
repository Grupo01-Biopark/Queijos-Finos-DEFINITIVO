package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TransferStatusProductionDTO;
import com.example.demo.entity.enums.TipoStatusProduction;
import com.example.demo.repository.TransferRepository;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;

    public TransferStatusProductionDTO getStatusCounts() {
        TransferStatusProductionDTO counts = new TransferStatusProductionDTO();
        counts.setProducingCount(transferRepository.countByTipoStatusProduction(TipoStatusProduction.PRODUCING));
        counts.setComplementationCount(transferRepository.countByTipoStatusProduction(TipoStatusProduction.COMPLEMENTATION));
        counts.setWithdrawalCount(transferRepository.countByTipoStatusProduction(TipoStatusProduction.WITHDRAWAL));
        counts.setDisconnectedCount(transferRepository.countByTipoStatusProduction(TipoStatusProduction.DISCONNECTED));
        return counts;
    }
}
