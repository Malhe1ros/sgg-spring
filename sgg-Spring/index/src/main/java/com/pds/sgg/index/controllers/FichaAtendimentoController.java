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
/**
 * Controller responsável pelas rotas das fichas de atendimento
 */
@RestController
@RequestMapping("/fichasAtendimento")
public class FichaAtendimentoController {
    /**
     * Retorna todas as fichas de atendimento de um paciente
     *
     * @param long Recebe o ID do paciente
     *
     * @return  retorna uma Response entity com status "Ok" e as fichas de atendimento ou "Erro"
     */
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

    /**
     * Retorna todas as fichas de atendimento
     *
     * @return  retorna uma Response entity com status "Ok" e as fichas de atendimento ou "Erro"
     */
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

    /**
     * Deleta uma ficha de atendimento
     *
     * @param long Recebe o ID da ficha
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
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
