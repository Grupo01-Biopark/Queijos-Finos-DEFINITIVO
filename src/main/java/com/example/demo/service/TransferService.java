package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transfer;
import com.example.demo.repository.TransferRepository;



@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public void createTransfer(Transfer transfer) {
        // Lógica para validar e salvar a transferência no banco de dados
        transferRepository.save(transfer);
    }


    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

}
