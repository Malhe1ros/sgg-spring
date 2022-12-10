package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.fichaAtendimento.Exames;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável pelas rotas dos exames
 */
@RestController
@RequestMapping("/exames")
public class ExamesController {
    /**
     * Retorna todos os exames de um paciente
     *
     * @param long Recebe o ID do paciente
     *
     * @return  retorna uma Response entity com status "Ok" e os exames ou "Erro"
     */
    @RequestMapping(value = "/getAllExamesByPaciente/{id}", method =  RequestMethod.GET)
    public ResponseEntity getAllExamesByPaciente (@PathVariable(value = "id") long id)
    {
        try{
            List<Exames> exame = Database.getInstance().examesGetAllByPaciente(id);
            return new ResponseEntity<>(exame, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Cadastra um exame
     *
     * @param Exames Recebe um parâmetro do tipo "Exames" e cadastra no banco de dados
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity cadastrarExame(@RequestBody Exames exame) {
        try{
            exame = Database.getInstance().examesSave(exame);
            return new ResponseEntity<>(exame, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza o exame de um paciente
     *
     * @param long Recebe o ID do exame
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarExame(@RequestBody Exames exame, @PathVariable(value = "id") long id) {
        try{
            Exames e = Database.getInstance().examesFindById(id);
            if(e != null){
                e.setDescricao(exame.getDescricao());
                e.setIdPaciente(exame.getIdPaciente());
                e.setRealizado(exame.getRealizado());
                Database.getInstance().examesSave(e);
                return new ResponseEntity<>(e, HttpStatus.OK);
            } else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deleta o exame de um paciente
     *
     * @param long Recebe o ID do exame
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarExame(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().examesFindById(id) != null){
                Database.getInstance().examesDeleteById(id);
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
