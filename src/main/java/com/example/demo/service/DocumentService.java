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
        private DocumentRepository documentRepository;

        @Validated
        public Document createDocument(@Valid Document document) {
            Objects.requireNonNull(document, "Documento invalidado. Verifique os campos obrigatórios.");
            return documentRepository.save(document);
        }

        public List<Document> getListDocument() {
            List<Document> documents = documentRepository.findAll();
            return documents != null ? documents : Collections.emptyList();
        }

        public void deleteDocument(Long documentId) {
            documentRepository.deleteById(documentId);
        }
    }
