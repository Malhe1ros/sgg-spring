package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.Pessoa;
import com.pds.sgg.index.repository.pessoa.PessoaRepository;

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
public class PessoaController {
    @Autowired
    PessoaRepository pessoaDB;

    @RequestMapping(value = "/pessoa/getPessoaById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getPessoaById (@PathVariable(value = "id") long id)
    {
        try{
            Optional<Pessoa> p = pessoaDB.findById(id);
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

    @RequestMapping(value = "/pessoas", method =  RequestMethod.GET)
    public ResponseEntity getAllPessoas ()
    {
        try{
            List<Pessoa> p = pessoaDB.findAll();

            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/pessoa/cadastrar", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPessoa (@RequestBody Pessoa pessoa)
    {
        try{
            pessoaDB.save(pessoa);

            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
