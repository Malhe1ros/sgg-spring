package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ConsultaRepository;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.FichaAtendimentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConsultaController {
    @Autowired
    ConsultaRepository consultasDB;

    @Autowired
    FichaAtendimentoRepository fichaAtendimentoDB;

    @RequestMapping(value = "/consultas/{id}", method =  RequestMethod.GET)
    public ResponseEntity getConsultasById (@PathVariable(value = "id") long id)
    {

        try{
            List<Consulta> consultas = consultasDB.getConsultasByIdPaciente(id);
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/consultas/all", method =  RequestMethod.GET)
    public ResponseEntity getAllConsultas ()
    {

        try{
            List<Consulta> consultas = consultasDB.getAll();
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/consultas", method = RequestMethod.POST)
    public ResponseEntity cadastrarConsulta(@RequestBody Consulta consulta) {
        try{
            consultasDB.save(consulta);
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/consultas/finalizar", method = RequestMethod.POST)
    public ResponseEntity cadastrarConsulta(@RequestBody FichaAtendimento ficha) {
        try{
            Optional<Consulta> c = consultasDB.findById(ficha.getIdConsulta());
            if(c.isPresent()){
                ficha = fichaAtendimentoDB.save(ficha);
                c.get().setIdFichaAtendimento(ficha.getId());
            } else{
                return new ResponseEntity<>("Consulta não cadastrada.", HttpStatus.FORBIDDEN);
            }
            
            return new ResponseEntity<>(ficha, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
}
