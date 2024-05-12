package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Transfer;
import com.example.demo.entity.enums.TipoStatusProduction;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    List<Long> countAllByTipoStatusProduction(TipoStatusProduction tipoStatusProduction);

}
