package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;

import jakarta.validation.Valid;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository DocumentRepository;

    @Validated
    public Document createDocument(@Valid Document Document) {
        Objects.requireNonNull(Document, "Documento invalidado. Verifique os campos obrigatórios.");
        return DocumentRepository.save(Document);
    }

    public List <Document> getListDocument(){
        List<Document> technologies = DocumentRepository.findAll();
        return technologies != null ? technologies : Collections.emptyList();
    }

    public void deleteDocument(Long DocumentId) {
        DocumentRepository.deleteById(DocumentId);
    }

}
