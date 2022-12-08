package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.entity.pessoa.medico.Medico;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.FichaAtendimentoRepository;
import com.pds.sgg.index.repository.pessoa.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class MedicoController {
    @Autowired
    MedicoRepository medicoDB;

    @RequestMapping(value = "/medico/{id}", method =  RequestMethod.GET)
    public ResponseEntity getAllMedicos (@PathVariable(value = "id") long id)
    {
        System.out.println("Oi");
        try{
            List<Medico> medicos = null;
            medicoDB.getMedicos(id);
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
