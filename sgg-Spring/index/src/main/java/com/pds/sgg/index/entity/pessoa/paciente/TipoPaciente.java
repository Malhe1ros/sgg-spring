package com.pds.sgg.index.entity.pessoa.paciente;

public enum TipoPaciente {
    CLINICA("clinica"),
    PRONTO_SOCORRO("pronto-socorro");

    private String unidade;
    TipoPaciente(String unidade){
        this.unidade = unidade;
    }
    public String getTipoPaciente() {
        return unidade;
    }

}
