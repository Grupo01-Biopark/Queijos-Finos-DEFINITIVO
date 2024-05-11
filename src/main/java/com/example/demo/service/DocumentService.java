package com.example.demo.service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;

import jakarta.persistence.Query;
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
        List<Document> Document = DocumentRepository.findAll();
        return Document != null ? Document : Collections.emptyList();
    }

    public void deleteDocument(Long DocumentId) {
        DocumentRepository.deleteById(DocumentId);
    }

       public Map<Long, Map<String, Map<String, Long>>> generateReportForAllTechnologies() {
        Query query = entityManager.createNativeQuery(
                "SELECT t.id, t.title, t.file, t.date, t.dateSystem, t.category, COUNT(*) " +
                        "FROM tb_Document t " +
                        "LEFT JOIN tb_transfer tt ON t.id = tt.Document_id " +
                        "GROUP BY t.id, t.title, t.file, t.date, t.dateSystem, t.category,");

}
