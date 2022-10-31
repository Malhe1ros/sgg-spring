package com.pds.sgg.index.entity.clinica;


import com.pds.sgg.index.entity.UnidadeHospitalar;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Clinica implements UnidadeHospitalar {
    @Id
    @SequenceGenerator(
            name = "clinica_sequence",
            sequenceName = "clinica_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clinica_sequence"
    )
    private Long id;
    private List<Long> idsPacientes;

    public Clinica(Long id, List<Long> idsPacientes) {
        this.id = id;
        this.idsPacientes = idsPacientes;
    }
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public List<Long> getIdsPacientes() {
        return idsPacientes;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public void setIdsPacientes(List<Long> idsPacientes) {
        this.idsPacientes = idsPacientes;
    }
}