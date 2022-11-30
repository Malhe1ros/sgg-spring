package com.pds.sgg.index.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.FichaAtendimentoRepository;

@RestController
public class FichaAtendimentoController {
    @Autowired
    FichaAtendimentoRepository fichaAtendimentoDB;

    @RequestMapping(value = "/fichasAtendimento/{id}", method =  RequestMethod.GET)
    public ResponseEntity getFichasAtendimentoByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            List<FichaAtendimento> consulta = null/*fichaAtendimentoDB.getFichasAtendimentoByPaciente(id)*/;
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
