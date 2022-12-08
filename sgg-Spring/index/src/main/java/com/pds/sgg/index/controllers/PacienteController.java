package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.entity.pessoa.paciente.TipoPaciente;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class  PacienteController {
    @RequestMapping(value = "/getPacienteById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getFichasAtendimentoByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            Paciente p = Database.getInstance().pacienteFindById(id);
            if(p != null){
                return new ResponseEntity<>(p, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllPacientes", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientes ()
    {
        try{
            List<Paciente> p = Database.getInstance().pacienteGetAll();

            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllPacientesClinica", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientesClinica()
    {
        try{
            List<Paciente> pacientes = Database.getInstance().pacienteGetAll();
            List<Paciente> pacientesClinica = new ArrayList<Paciente>();

            for(Paciente p : pacientes){
                if(p.getTipoPaciente() == TipoPaciente.CLINICA) pacientesClinica.add(p);
            }

            return new ResponseEntity<>(pacientesClinica, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllPacientesProntoSocorro", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientesProntoSocorro()
    {
        try{
            List<Paciente> pacientes = Database.getInstance().pacienteGetAll();
            List<Paciente> pacientesPs = new ArrayList<Paciente>();

            for(Paciente p : pacientes){
                if(p.getTipoPaciente() == TipoPaciente.PRONTO_SOCORRO) pacientesPs.add(p);
            }

            return new ResponseEntity<>(pacientesPs, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPaciente (@RequestBody Paciente paciente)
    {
        System.out.println(paciente);
        if(paciente.getTipoPaciente()==TipoPaciente.PRONTO_SOCORRO && paciente.getUrgencia()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            paciente = Database.getInstance().pacienteSave(paciente);
            
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarPaciente(@RequestBody Paciente paciente, @PathVariable(value = "id") long id) {
        try{
            Paciente p = Database.getInstance().pacienteFindById(id);
            if(p != null){
                p.setIdPessoa(paciente.getIdPessoa());
                p.setTipoPaciente(paciente.getTipoPaciente());
                p.setUrgencia(paciente.getUrgencia());
                Database.getInstance().pacienteSave(p);
                return new ResponseEntity<>(p, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Entidade não encontrada.", HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarPaciente(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().pacienteFindById(id) != null){
                Database.getInstance().pacienteDeleteById(id);
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
