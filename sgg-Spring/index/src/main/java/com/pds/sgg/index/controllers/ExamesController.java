package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamesController {
    @RequestMapping(value = "/exame/{id}", method =  RequestMethod.GET)
    public String getExameByPaciente (@PathVariable(value = "id") long id)
    {
        //Usar o find através do ID do paciente fornecido.
        return "Exame único retornado com sucesso!";

    }

    @RequestMapping(value = "/exame", method = RequestMethod.POST)
    public String cadastrarExame(@RequestBody Exames exame) {
        //Persistir o exame no banco antes de retornar mensagem de retorno
        return "Exame cadastrado!";
    }
}
