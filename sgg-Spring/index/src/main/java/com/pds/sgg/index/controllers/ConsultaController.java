package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsultaController {
    @RequestMapping(value = "/consultas/{id}", method =  RequestMethod.GET)
    public String getConsultasById (@PathVariable(value = "id") long id)
    {
        //Usar o find atravées do ID do paciente fornecido.
        return "Consulta única retornada com sucesso!";

    }

    @RequestMapping(value = "/consultas", method = RequestMethod.POST)
    public String cadastrarConsulta(@RequestBody Consulta consulta) {
        //Persistir a consulta no banco antes de retornar mensagem de retorno
        return "Consulta cadastrada!";
    }
}
