package com.pds.sgg.index.entity.prontoSocorro;

import com.pds.sgg.index.entity.UnidadeHospitalar;

import java.util.List;

public class ProntoSocorro implements UnidadeHospitalar {
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