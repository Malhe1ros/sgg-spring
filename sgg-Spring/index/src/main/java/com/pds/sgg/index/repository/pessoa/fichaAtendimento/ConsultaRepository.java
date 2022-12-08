package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    //@Query()
    //
    @Query(value = "SELECT c FROM consulta c INNER JOIN ficha_atendimento f ON c.id_ficha_atendimento = f.id_consulta WHERE f.id_paciente = ?1", nativeQuery = true)
    List<Consulta> getConsultasByIdPaciente(Long id);
    @Query(value = "SELECT * FROM consulta", nativeQuery = true)
    List<Consulta> getAll();
}
