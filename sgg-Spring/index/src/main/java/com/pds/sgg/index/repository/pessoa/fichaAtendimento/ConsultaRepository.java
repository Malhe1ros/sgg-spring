package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT * FROM Consulta c INNER JOIN FichaAtendimento f ON c.idFichaAtendimento = f.id WHERE f.idPaciente = ?1")
    List<Consulta> getConsultasByIdPaciente(Long id);
}
