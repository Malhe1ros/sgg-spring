package com.pds.sgg.index.entity.pessoa.fichaAtendimento;

/**
 * Enum utilizado para controlar os Status da consulta
 */
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
