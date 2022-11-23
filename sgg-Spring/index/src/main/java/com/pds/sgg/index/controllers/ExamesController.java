package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.repository.pessoa.fichaAtendimento.ExamesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExamesController {
    @Autowired
    ExamesRepository examesDB;

    @RequestMapping(value = "/exame/{id}", method =  RequestMethod.GET)
    public ResponseEntity getAllExamesByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            List<Exames> exame = examesDB.getAllExamesByPaciente(id);
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

    @RequestMapping(value = "/exame/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarExame(@RequestBody Exames exame, @PathVariable(value = "id") long id) {
        try{
            Optional<Exames> opt = examesDB.findById(id);
            if(opt.isPresent()){
                Exames e = opt.get();
                e.setDescricao(exame.getDescricao());
                e.setIdPaciente(exame.getIdPaciente());
                e.setRealizado(exame.getRealizado());
                examesDB.save(e);
                return new ResponseEntity<>(e, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @RequestMapping(value = "/exame/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarExame(@PathVariable(value = "id") long id) {
        try{
            if(examesDB.findById(id).isPresent()){
                examesDB.deleteById(id);
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
