package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ConsultaController {
    @Autowired
    ConsultaRepository consultasDB;
    @RequestMapping(value = "/consultas/{id}", method =  RequestMethod.GET)
    public ResponseEntity getConsultasById (@PathVariable(value = "id") long id)
    {
        Optional<Consulta> consulta = consultasDB.findById(id);
        return new ResponseEntity<>(consulta, HttpStatus.OK);
    }

    @RequestMapping(value = "/consultas", method = RequestMethod.POST)
    public String cadastrarConsulta(@RequestBody Consulta consulta) {
        consultasDB.save(consulta);
        return "Consulta cadastrada!";
    }
}
