package com.pds.sgg.index.repository.pessoa.medico;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.medico.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query(value = "SELECT * FROM medicos", nativeQuery = true)
    List<Consulta> getMedicos(Long id);
}
