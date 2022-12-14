package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
/**
 * Entidade das Consultas
 */
public class Consulta {
    @Id
    @SequenceGenerator(
            name = "consulta_sequence",
            sequenceName = "consulta_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consulta_sequence"
    )
    private Long id;
    private String sala;
    private Date data;
    private StatusConsulta status;
    private Long idFichaAtendimento;

    public Consulta (Long id, String sala, Date data, StatusConsulta status, Long idFichaAtendimento) {
        this.id = id;
        this.sala = sala;
        this.data = data;
        this.status = status;
        this.idFichaAtendimento = idFichaAtendimento;
    }

    public Consulta() {

    }

    public Long getId() {
        return id;
    }

    public  String getSala() {
        return sala;
    }

    public Date getData() {
        return data;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public Long getIdFichaAtendimento() {
        return idFichaAtendimento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public void setIdFichaAtendimento(Long idFichaAtendimento) {
        this.idFichaAtendimento = idFichaAtendimento;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", sala='" + sala + '\'' +
                ", data=" + data +
                ", status=" + status +
                ", idFichaAtendimento=" + idFichaAtendimento +
                '}';
    }
}
