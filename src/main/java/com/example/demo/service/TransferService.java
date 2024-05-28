package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Transfer;
import com.example.demo.repository.TransferRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;

    public void createTransfer(Transfer transfer) {

        transferRepository.save(transfer);
    }

    @Validated
    public Transfer updateTransfer(Transfer updateTransfer) {
        if (updateTransfer.getId() == null) {
            throw new IllegalArgumentException("ID da transferência não fornecido no objeto atualizado.");
        }

        Optional<Transfer> optionalTransfer = transferRepository.findById(updateTransfer.getId());

        if (optionalTransfer.isPresent()) {
            Transfer existingTransfer = optionalTransfer.get();
            existingTransfer.setTechnology(updateTransfer.getTechnology());
            existingTransfer.setTipoStatusProduction(updateTransfer.getTipoStatusProduction());
            existingTransfer.setStartDate(updateTransfer.getStartDate());
            existingTransfer.setCompletionDate(updateTransfer.getCompletionDate());
            return transferRepository.save(existingTransfer);
        } else {
            throw new IllegalArgumentException("Transfer não encontrada com o ID fornecido: " + updateTransfer.getId());
        }
    }

    public List<Transfer> getAllTransfers() {
        return transferRepository.findAll();
    }

    public Transfer getTransferById(Long id) {
        return transferRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transferência não encontrada"));
    }
}
