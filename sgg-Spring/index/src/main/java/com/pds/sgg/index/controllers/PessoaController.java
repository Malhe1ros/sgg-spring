package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.Pessoa;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Responsável pelas rotas de Pessoa
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    /**
     * Retorna uma pessoa específica
     *
     * @param long Recebe o ID de uma pessoa
     *
     * @return  retorna uma Response entity com status "Ok" e a pessoa ou "Erro"
     */
    @RequestMapping(value = "/getPessoaById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getPessoaById (@PathVariable(value = "id") long id)
    {
        try{
            Pessoa p = Database.getInstance().pessoaFindById(id);
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

    /**
     * Retorna todas as pessoas
     *
     *
     * @return  retorna uma Response entity com status "Ok" e as pessoas ou "Erro"
     */
    @RequestMapping(value = "/getAllPessoas", method =  RequestMethod.GET)
    public ResponseEntity getAllPessoas ()
    {
        try{
            List<Pessoa> p = Database.getInstance().pessoasGetAll();

            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Cadastra uma pessoa no banco de dados
     *
     * @param Pessoa Recebe um parâmetro do tipo Pessoa
     *
     * @return  retorna uma Response entity com status "Ok" e a pessoa cadastrada ou "Erro"
     */
    @RequestMapping(value = "", method =  RequestMethod.POST)
    public ResponseEntity cadastrarPessoa (@RequestBody Pessoa pessoa)
    {
        try{
            pessoa = Database.getInstance().pessoaSave(pessoa);

            return new ResponseEntity<>(pessoa, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza os dados de uma pessoa
     *
     * @param long Recebe o ID de uma pessoa
     *
     * @return  retorna uma Response entity com status "Ok" e a pessoa atualizada ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarPessoa(@RequestBody Pessoa pessoa, @PathVariable(value = "id") long id) {
        try{
            Pessoa p = Database.getInstance().pessoaFindById(id);
            if(p != null){
                p.setEmail(pessoa.getEmail());
                p.setEndereco(pessoa.getEndereco());
                p.setIdUsuario(pessoa.getIdUsuario());
                p.setNome(pessoa.getNome());
                p.setTelefone(pessoa.getTelefone());
                Database.getInstance().pessoaSave(p);
                return new ResponseEntity<>(p, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Entidade não encontrada.", HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deleta uma pessoa do banco de dados
     *
     * @param long Recebe o ID de uma pessoa
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarPessoa(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().pessoaFindById(id) != null){
                Database.getInstance().pessoaDeleteById(id);
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
