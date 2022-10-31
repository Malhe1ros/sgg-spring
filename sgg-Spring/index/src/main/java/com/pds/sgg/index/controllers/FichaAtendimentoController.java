package com.pds.sgg.index.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FichaAtendimentoController {
    @RequestMapping(value = "/fichasAtendimento/{id}", method =  RequestMethod.GET)
    public String getFichasAtendimentoByPaciente (@PathVariable(value = "id") long id)
    {
        //Usar o find através do ID do paciente fornecido.
        return "Ficha de atendimento única retornada com sucesso!";

    }
}
