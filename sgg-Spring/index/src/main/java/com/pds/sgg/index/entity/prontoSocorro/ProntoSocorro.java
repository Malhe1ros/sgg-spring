package com.pds.sgg.index.entity.prontoSocorro;

import com.pds.sgg.index.entity.UnidadeHospitalar;

import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class ProntoSocorro implements UnidadeHospitalar {
    @Id
    @SequenceGenerator(
        name = "pronto_socorro_sequence",
        sequenceName = "pronto_socorro_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "pronto_socorro_sequence"
    )    
    private Long id;
    private List<Long> idsPacientes;

    public ProntoSocorro(Long id, List<Long> idsPacientes) {
        this.id = id;
        this.idsPacientes = idsPacientes;
    }
    @Override
    public Long getId(){
        return id;
    }
    @Override
    public List<Long>  getIdsPacientes() {
        return idsPacientes;
    }

    @Override
    public  void setId(Long id) {
        this.id = id;
    }
    @Override
    public void setIdsPacientes(List<Long> idsPacientes) {
        this.idsPacientes = idsPacientes;
    }



}