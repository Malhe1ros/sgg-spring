package com.pds.sgg.index.entity;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;

import java.util.List;
import java.util.Set;

public interface UnidadeHospitalar {
    public Long getId();
    public Set<Paciente> getIdsPacientes();
    public void setId(Long id);
    public void setIdsPacientes(Set<Paciente> idsPacientes);
}