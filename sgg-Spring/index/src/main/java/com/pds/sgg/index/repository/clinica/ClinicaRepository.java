package com.pds.sgg.index.repository.clinica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pds.sgg.index.entity.clinica.Clinica;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {
    
}
