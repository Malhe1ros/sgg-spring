package com.pds.sgg.index.repository.pessoa.paciente;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
