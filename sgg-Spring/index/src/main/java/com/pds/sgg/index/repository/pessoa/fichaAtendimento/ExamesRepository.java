package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamesRepository extends JpaRepository<Exames, Long> {
    @Query(value = "SELECT * FROM exames WHERE id_paciente = ?1", nativeQuery = true)
    List<Exames> getAllExamesByPaciente(Long id);
}
