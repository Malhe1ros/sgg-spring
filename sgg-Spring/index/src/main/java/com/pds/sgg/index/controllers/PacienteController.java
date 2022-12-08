package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.entity.pessoa.paciente.TipoPaciente;
import com.pds.sgg.index.repository.pessoa.paciente.PacienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  PacienteController {
    @Autowired
    PacienteRepository pacienteDB;

    @RequestMapping(value = "/paciente/getPacienteById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getFichasAtendimentoByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            Optional<Paciente> p = pacienteDB.findById(id);
            if(p.isPresent()){
                return new ResponseEntity<>(p.get(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/pacientes", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientes ()
    {
        try{
            List<Paciente> p = pacienteDB.findAll();

            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/pacientes/clinica", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientesClinica()
    {
        try{
            List<Paciente> pacientes = pacienteDB.findAll();
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

    @RequestMapping(value = "/pacientes/prontoSocorro", method =  RequestMethod.GET)
    public ResponseEntity getAllPacientesProntoSocorro()
    {
        try{
            List<Paciente> pacientes = pacienteDB.findAll();
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

    @RequestMapping(value = "/paciente/cadastrar", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPaciente (@RequestBody Paciente paciente)
    {
        System.out.println(paciente);
        if(paciente.getTipoPaciente()==TipoPaciente.PRONTO_SOCORRO && paciente.getUrgencia()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{
            pacienteDB.save(paciente);
            
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
}
