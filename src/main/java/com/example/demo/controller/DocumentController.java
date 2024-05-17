package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/Documentos")
    public ModelAndView iniciarTela() {
        ModelAndView modelAndView = new ModelAndView("GerenciadorDocumentos");
        modelAndView.addObject("document", new Document());
        modelAndView.addObject("documents", getAllDocuments());
        return modelAndView;
    }

    @PostMapping("/Documentos/cadastrar")
    public RedirectView createDocument(@ModelAttribute("document") Document document, RedirectAttributes attributes) {
        try {
            documentService.createDocument(document);
            attributes.addFlashAttribute("mensagem", "Documento adicionado com sucesso");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("mensagem", "Erro ao adicionar o documento: " + e.getMessage());
        }
        return new RedirectView("/Documentos");
    }

    @GetMapping("/Documentos/lista")
    public List<Document> getAllDocuments() {
        return documentService.getListDocument();
    }

    @DeleteMapping("/Documentos/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        documentService.deleteDocument(documentId);
        return ResponseEntity.ok().build();
    }
}
