package com.pds.sgg.index.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.FichaAtendimento;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

@RestController
@RequestMapping("/fichasAtendimento")
public class FichaAtendimentoController {
    @RequestMapping(value = "/getFichasAtendimentoByPaciente/{id}", method =  RequestMethod.GET)
    public ResponseEntity getFichasAtendimentoByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            List<FichaAtendimento> fichas = Database.getInstance().fichasAtendimentoFindByPaciente(id);
            return new ResponseEntity<>(fichas, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllFichasAtendimento/all", method =  RequestMethod.GET)
    public ResponseEntity getAllFichasAtendimento ()
    {
        try{
            List<FichaAtendimento> fichas = Database.getInstance().fichasAtendimentoGetAll();
            return new ResponseEntity<>(fichas, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarFichaAtendimento(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().fichasAtendimentoFindById(id) != null){
                Database.getInstance().fichasAtendimentoDeleteById(id);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Entidade não encontrada.", HttpStatus.FORBIDDEN);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }     
}
