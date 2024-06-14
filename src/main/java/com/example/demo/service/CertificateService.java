package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.enums.TipoCertificado;
import com.example.demo.repository.CertificateRepository;

@Service
public class CertificateService {
   
    @Autowired
    private CertificateRepository certificateRepository;    

    public long countCertificadoSIMPOA() {
    return certificateRepository.countByTipoCertificado(TipoCertificado.SIMPOA);

    }

    public long countCertificadoSUSAF() {
        return certificateRepository.countByTipoCertificado(TipoCertificado.SUSAF);
    
    }

    public long countCertificadoSISBI() {
        return certificateRepository.countByTipoCertificado(TipoCertificado.SISBI);
    
    }
    
    public long countCertificadoSELOARTE() {
        return certificateRepository.countByTipoCertificado(TipoCertificado.SELOARTE);
        
    }

    public long countCertificadoCIF() {
        return certificateRepository.countByTipoCertificado(TipoCertificado.CIF); //SIF
    
    }    
}