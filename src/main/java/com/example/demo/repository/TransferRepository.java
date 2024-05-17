package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Transfer;
import com.example.demo.entity.enums.TipoStatusProduction;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    long countByTipoStatusProduction(TipoStatusProduction tipoStatusProduction);
    
}
