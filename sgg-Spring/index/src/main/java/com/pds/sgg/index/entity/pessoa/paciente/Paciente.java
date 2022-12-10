package com.pds.sgg.index.entity.pessoa.paciente;
import javax.persistence.*;

@Entity
@Table
/**
 * Entidade dos Pacientes
 */
public class Paciente {
    @Id
    @SequenceGenerator(
        name = "paciente_sequence",
        sequenceName = "paciente_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "paciente_sequence"
    )
    private Long id;
    private Long idPessoa;
    private TipoPaciente tipoPaciente;

    private Boolean isUrgencia;

    public Paciente(Long id, Long idPessoa, TipoPaciente tipoPaciente,Boolean isUrgencia) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.tipoPaciente = tipoPaciente;
        this.isUrgencia = isUrgencia;
    }

    public Paciente() {

    }

    public Long getId() {
        return id;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public TipoPaciente getTipoPaciente() {
        return tipoPaciente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setTipoPaciente(TipoPaciente tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public Boolean getUrgencia() {
        return isUrgencia;
    }

    public void setUrgencia(Boolean urgencia) {
        this.isUrgencia = urgencia;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", idPessoa=" + idPessoa +
                ", tipoPaciente=" + tipoPaciente +
                ", isUrgencia=" + isUrgencia +
                '}';
    }
}
