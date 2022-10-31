package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public String cadastrarPaciente (@RequestBody Paciente paciente)
    {
        return "Paciente Cadastrado !";
        //Atenção, esse método ainda deverá ser implementado através do PostgresSQL
        //Por enquanto, esse método está retornando o paciente que foi cadastrado, mas depois deverá persistir esse paciente no banco.

    }
}
