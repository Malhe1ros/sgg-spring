package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
/**
 * Entidade das fichas de Atendimento
 */
public class FichaAtendimento {
    @Id
    @SequenceGenerator(
            name = "ficha_atendimento_sequence",
            sequenceName = "ficha_atendimento_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ficha_atendimento_sequence"
    )
    private Long id;
    private Long idPaciente;
    private Long idMedico;
    private Long idEspecialidade;
    private Long idConsulta;
    private String anotacoes;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Exames> exames;

    public FichaAtendimento(){

    }

    public FichaAtendimento(Long id, Long idPaciente, Long idMedico, Long idEspecialidade, Long idConsulta, String anotacoes, Set<Exames> exames) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idEspecialidade = idEspecialidade;
        this.idConsulta = idConsulta;
        this.anotacoes = anotacoes;
        this.exames = exames;
    }

    public Long getId() {
        return id;
    }
    public Long getIdPaciente() {
        return idPaciente;
    }
    public Long getIdMedico() {
        return idMedico;
    }
    public Long getIdEspecialidade() {
        return idEspecialidade;
    }
    public Long getIdConsulta() {
        return idConsulta;
    }
    public String getAnotacoes() {
        return anotacoes;
    }
    public Set<Exames> getExames() {
        return exames;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }
    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    public void setExames (Set<Exames>exames) {
        this.exames = exames;
    }
}
