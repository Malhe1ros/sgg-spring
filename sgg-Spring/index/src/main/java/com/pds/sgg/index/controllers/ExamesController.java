package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ExamesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExamesController {
    @Autowired
    ExamesRepository examesDB;

    @RequestMapping(value = "/exame/{id}", method =  RequestMethod.GET)
    public ResponseEntity getExameByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            Optional<Exames> exame = examesDB.findById(id);
            return new ResponseEntity<>(exame, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/exame", method = RequestMethod.POST)
    public ResponseEntity cadastrarExame(@RequestBody Exames exame) {
        try{
            examesDB.save(exame);
            return new ResponseEntity<>(exame, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
