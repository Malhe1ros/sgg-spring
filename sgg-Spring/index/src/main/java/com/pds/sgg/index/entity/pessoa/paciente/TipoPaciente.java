package com.pds.sgg.index.entity.pessoa.paciente;

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
