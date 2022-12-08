package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaAtendimentoRepository extends JpaRepository<FichaAtendimento, Long> {
    @Query(value = "SELECT * FROM ficha_atendimento f WHERE f.id_paciente = ?1", nativeQuery = true)
    List<FichaAtendimento> getFichasAtendimentoByPaciente(Long id);
}
