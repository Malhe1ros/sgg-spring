package com.pds.sgg.index.repository.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.medico.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
}
