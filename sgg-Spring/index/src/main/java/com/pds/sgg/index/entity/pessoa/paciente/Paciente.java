package com.pds.sgg.index.entity.pessoa.paciente;
import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table
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

    public Paciente(Long id, Long idPessoa, TipoPaciente tipoPaciente) {
        this.id = id;
        this.idPessoa = idPessoa;
        this.tipoPaciente = tipoPaciente;
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
}
