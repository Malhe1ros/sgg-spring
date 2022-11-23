package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.repository.pessoa.paciente.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController {
    @Autowired
    PacienteRepository pacienteDB;

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPaciente (@RequestBody Paciente paciente)
    {
        try{
            pacienteDB.save(paciente);
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
}
