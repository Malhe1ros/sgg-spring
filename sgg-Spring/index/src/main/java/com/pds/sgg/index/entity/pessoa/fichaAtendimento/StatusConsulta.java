package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

public enum StatusConsulta {
    AGENDADO("Agendado"),
    CANCELADO("Cancelado"),
    FINALIZADO("Finalizado");

    private String status;

    StatusConsulta (String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
