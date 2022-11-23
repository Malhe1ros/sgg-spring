package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

import javax.persistence.*;

@Entity
@Table
public class Exames {
    @Id
    @SequenceGenerator(
            name = "exames_sequence",
            sequenceName = "exames_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exames_sequence"
    )
    private Long id;
    private Long idPaciente;
    private String descricao;
    private Boolean realizado;

    public Exames(Long id, Long idPaciente, String descricao, Boolean realizado){
        this.id = id;
        this.idPaciente = idPaciente;
        this.descricao = descricao;
        this.realizado = realizado;
    }

    public Long getId() {
        return id;
    }
    public Long getIdPaciente() {
        return idPaciente;
    }
    public String getDescricao() {
        return descricao;
    }
    public Boolean getRealizado() {
        return realizado;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void  setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
}
