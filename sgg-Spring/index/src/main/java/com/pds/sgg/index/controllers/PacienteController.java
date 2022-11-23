package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.clinica.Clinica;
import com.pds.sgg.index.entity.pessoa.paciente.Paciente;
import com.pds.sgg.index.entity.pessoa.paciente.TipoPaciente;
import com.pds.sgg.index.entity.prontoSocorro.ProntoSocorro;
import com.pds.sgg.index.repository.clinica.ClinicaRepository;
import com.pds.sgg.index.repository.pessoa.paciente.PacienteRepository;
import com.pds.sgg.index.repository.prontoSocorro.ProntoSocorroRepository;

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
public class PacienteController {
    @Autowired
    PacienteRepository pacienteDB;

    @Autowired
    ClinicaRepository clinicaDB;
    
    @Autowired
    ProntoSocorroRepository prontoSocorroDB;    

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

    @RequestMapping(value = "/paciente/cadastrar", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPaciente (@RequestBody Paciente paciente)
    {
        try{
            pacienteDB.save(paciente);

            if(paciente.getTipoPaciente() == TipoPaciente.CLINICA){
                Clinica c = clinicaDB.findAll().get(0);
                c.getIdsPacientes().add(paciente.getId());
                clinicaDB.save(c);
            }else if(paciente.getTipoPaciente() == TipoPaciente.PRONTO_SOCORRO){
                ProntoSocorro ps = prontoSocorroDB.findAll().get(0);
                ps.getIdsPacientes().add(paciente.getId());
                prontoSocorroDB.save(ps);
            }
            
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
}
