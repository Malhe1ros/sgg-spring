package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.pessoa.medico.Medico;
import com.pds.sgg.index.repository.DatabaseConnection.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsável pelas operações das rotas dos médicos
 */
@RestController
@RequestMapping("/medico")
public class MedicoController {
    /**
     * Retorna todos os médicos cadastrados
     *
     * @return  retorna uma Response entity com status "Ok" e os médicos ou "Erro"
     */
    @RequestMapping(value = "/getAllMedicos", method =  RequestMethod.GET)
    public ResponseEntity getAllMedicos ()
    {
        try{
            List<Medico> medicos = Database.getInstance().medicoGetAll();
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retorna um médico específico
     *
     * @param long Recebe o ID do médico
     *
     * @return  retorna uma Response entity com status "Ok" e o médico ou "Erro"
     */
    @RequestMapping(value = "/getMedicoById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getMedicoById (@PathVariable(value = "id") long id)
    {
        try{
            Medico medico = Database.getInstance().medicoFindById(id);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Cadastra um médico no banco de dados
     *
     * @param Medico Recebe a classe "médico"
     *
     * @return  retorna uma Response entity com status "Ok" e o médico cadastrado ou "Erro"
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity cadastrarMedico(@RequestBody Medico medico) {
        try{
            medico = Database.getInstance().medicoSave(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Atualiza os dados de um Médico específico
     *
     * @param long Recebe o ID do médico
     *
     * @return  retorna uma Response entity com status "Ok" e o médico ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarMedico(@RequestBody Medico medico, @PathVariable(value = "id") long id) {
        try{
            Medico m = Database.getInstance().medicoFindById(id);
            if(m != null){
                m.setEmail(medico.getEmail());
                m.setEndereco(medico.getEndereco());
                m.setIdPessoa(medico.getIdPessoa());
                m.setIdUsuario(medico.getIdUsuario());
                m.setIdsEspecialidades(medico.getIdsEspecialidades());
                m.setNome(medico.getNome());
                m.setTelefone(medico.getTelefone());
                Database.getInstance().medicoSave(m);
                return new ResponseEntity<>(m, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Entidade não encontrada.", HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deleta um médico específico
     *
     * @param long Recebe o ID do médico
     *
     * @return  retorna uma Response entity com status "Ok" ou "Erro"
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarMedico(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().medicoFindById(id) != null){
                Database.getInstance().medicoDeleteById(id);
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
