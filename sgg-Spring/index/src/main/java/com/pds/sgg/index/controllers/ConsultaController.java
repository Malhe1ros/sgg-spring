package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Consulta;
import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @RequestMapping(value = "/getConsultasByIdPaciente/{id}", method =  RequestMethod.GET)
    public ResponseEntity getConsultasByIdPaciente (@PathVariable(value = "id") long id)
    {
        try{
            List<Consulta> consultas = Database.getInstance().consultasFindByIdPaciente(id);
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllConsultas", method =  RequestMethod.GET)
    public ResponseEntity getAllConsultas ()
    {
        try{
            List<Consulta> consultas = Database.getInstance().consultasGetAll();
            return new ResponseEntity<>(consultas, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/cadastrarConsulta", method = RequestMethod.POST)
    public ResponseEntity cadastrarConsulta(@RequestBody Consulta consulta) {
        try{
            Database.getInstance().consultasSave(consulta);
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/finalizarConsulta", method = RequestMethod.POST)
    public ResponseEntity finalizarConsulta(@RequestBody FichaAtendimento ficha) {
        try{
            Consulta c = Database.getInstance().consultasFindById(ficha.getIdConsulta());
            if(c != null){
                ficha = Database.getInstance().fichasAtendimentoSave(ficha);
                c.setIdFichaAtendimento(ficha.getId());
            } else{
                return new ResponseEntity<>("Consulta não cadastrada.", HttpStatus.FORBIDDEN);
            }
            
            return new ResponseEntity<>(ficha, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarConsulta(@RequestBody Consulta consulta, @PathVariable(value = "id") long id) {
        try{
            Consulta c = Database.getInstance().consultasFindById(id);
            if(c != null){
                c.setData(consulta.getData());
                c.setIdFichaAtendimento(consulta.getIdFichaAtendimento());
                c.setSala(consulta.getSala());
                c.setStatus(consulta.getStatus());
                Database.getInstance().consultasSave(c);
                return new ResponseEntity<>(c, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarConsulta(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().consultasFindById(id) != null){
                Database.getInstance().consultasDeleteById(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }       
}
