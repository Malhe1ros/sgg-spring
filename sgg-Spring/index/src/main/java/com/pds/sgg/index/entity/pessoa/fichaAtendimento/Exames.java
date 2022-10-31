package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

public class Exames {
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
    public void setId() {
        this.id = id;
    }
    public void setIdPaciente() {
        this.idPaciente = idPaciente;
    }
    public void setDescricao() {
        this.descricao = descricao;
    }
    public void  setRealizado() {
        this.realizado = realizado;
    }
}
