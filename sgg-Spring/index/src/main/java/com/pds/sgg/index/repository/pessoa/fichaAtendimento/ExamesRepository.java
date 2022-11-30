package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamesRepository extends JpaRepository<Exames, Long> {
    //@Query("SELECT * FROM Exames e WHERE e.idPaciente = ?1")
    //List<Exames> getAllExamesByPaciente(Long id);
}
