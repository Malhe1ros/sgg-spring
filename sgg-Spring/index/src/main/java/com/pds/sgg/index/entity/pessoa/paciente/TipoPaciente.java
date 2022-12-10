package com.pds.sgg.index.entity.pessoa.paciente;
/**
 * Enum para controle dos tipos dos pacientes
 */
public enum TipoPaciente {
    CLINICA("CLINICA"),
    PRONTO_SOCORRO("PRONTO_SOCORRO");

    private String unidade;
    TipoPaciente(String unidade){
        this.unidade = unidade;
    }
    public String getTipoPaciente() {
        return unidade;
    }

}
