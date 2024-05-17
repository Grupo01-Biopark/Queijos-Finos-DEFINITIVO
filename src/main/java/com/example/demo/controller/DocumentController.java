package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Document;
import com.example.demo.service.DocumentService;

@RestController
public class DocumentController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
    private static final String UPLOAD_DIR = "uploads/";

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
    public RedirectView createDocument(@RequestParam("category") String category,
                                       @RequestParam("file") MultipartFile file,
                                       @RequestParam("title") String title,
                                       RedirectAttributes attributes) {
        Document document = new Document();
        document.setCategory(category);
        document.setTitle(title);

        try {
            String fileName = saveUploadedFile(file);
            document.setFile(fileName);

            logger.info("Saving document: {}", document);
            documentService.createDocument(document);

            attributes.addFlashAttribute("mensagem", "Documento adicionado com sucesso");
        } catch (DataIntegrityViolationException e) {
            logger.error("Data integrity violation: ", e);
            attributes.addFlashAttribute("mensagem", "Erro ao adicionar o documento: " + e.getMessage());
        } catch (IOException e) {
            logger.error("IO exception while saving file: ", e);
            attributes.addFlashAttribute("mensagem", "Erro ao salvar o arquivo: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
            attributes.addFlashAttribute("mensagem", "Erro inesperado: " + e.getMessage());
        }

        return new RedirectView("/Documentos");
    }

    @GetMapping("/Documentos/lista")
    public List<Document> getAllDocuments() {
        return documentService.getListDocument();
    }

    @DeleteMapping("/Documentos/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        try {
            documentService.deleteDocument(documentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error deleting document: ", e);
            return ResponseEntity.status(500).build();
        }
    }

    private String saveUploadedFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Arquivo vazio.");
        }

        // Cria o diretório de upload se não existir
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Verifica se o arquivo já existe e renomeia se necessário
        filePath = resolveFileNameConflict(filePath);

        Files.copy(file.getInputStream(), filePath);

        logger.info("Saved file: {}", filePath);

        return filePath.getFileName().toString();
    }

    private Path resolveFileNameConflict(Path filePath) throws IOException {
        if (!Files.exists(filePath)) {
            return filePath;
        }

        String fileName = filePath.getFileName().toString();
        String name = fileName;
        String extension = "";
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            name = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        }

        int count = 1;
        while (Files.exists(filePath)) {
            fileName = name + " (" + count + ")" + extension;
            filePath = filePath.getParent().resolve(fileName);
            count++;
        }

        return filePath;
    }

}
    