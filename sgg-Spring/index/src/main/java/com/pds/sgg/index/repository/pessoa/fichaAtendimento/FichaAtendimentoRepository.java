package com.pds.sgg.index.repository.pessoa.fichaAtendimento;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaAtendimentoRepository extends JpaRepository<FichaAtendimento, Long> {
    @Query("SELECT u FROM FichaAtendimento f WHERE f.idPaciente = ?1")
    List<FichaAtendimento> getFichasAtendimentoByPaciente(Long id);
}
