package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.enums.TipoStatusProduction;
import com.example.demo.repository.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public List<Long> countAllTipoStatusProductions() {
    List<Long> allCounts = new ArrayList<>();
    allCounts.addAll(transferRepository.countAllByTipoStatusProduction(TipoStatusProduction.PRODUCING));
    allCounts.addAll(transferRepository.countAllByTipoStatusProduction(TipoStatusProduction.COMPLEMENTATION));
    allCounts.addAll(transferRepository.countAllByTipoStatusProduction(TipoStatusProduction.WITHDRAWAL));
    allCounts.addAll(transferRepository.countAllByTipoStatusProduction(TipoStatusProduction.DISCONNECTED));
    return allCounts;
}

}
