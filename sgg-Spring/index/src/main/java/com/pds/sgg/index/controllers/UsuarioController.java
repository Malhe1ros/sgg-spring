package com.pds.sgg.index.controllers;

import com.pds.sgg.index.entity.Usuario;
import com.pds.sgg.index.repository.DatabaseConnection.Database;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @RequestMapping(value = "/getUsuarioById/{id}", method =  RequestMethod.GET)
    public ResponseEntity getUsuarioById (@PathVariable(value = "id") long id)
    {
        try{
            Usuario u = Database.getInstance().usuarioFindById(id);
            if(u != null){
                return new ResponseEntity<>(u, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/getAllUsuarios", method =  RequestMethod.GET)
    public ResponseEntity getAllUsuarios ()
    {
        try{
            List<Usuario> u = Database.getInstance().usuarioGetAll();

            return new ResponseEntity<>(u, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "", method =  RequestMethod.POST)
    public ResponseEntity cadastrarUsuario (@RequestBody Usuario usuario)
    {
        try{
            usuario = Database.getInstance().usuarioSave(usuario);

            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity atualizarUsuario(@RequestBody Usuario usuario, @PathVariable(value = "id") long id) {
        try{
            Usuario u = Database.getInstance().usuarioFindById(id);
            if(u != null){
                u.setEmail(usuario.getEmail());
                u.setName(usuario.getName());
                u.setPassword(usuario.getPassword());
                Database.getInstance().usuarioSave(u);
                return new ResponseEntity<>(u, HttpStatus.OK);
            } else{
                return new ResponseEntity<>("Entidade não encontrada.", HttpStatus.FORBIDDEN);
            }            
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletarUsuario(@PathVariable(value = "id") long id) {
        try{
            if(Database.getInstance().usuarioFindById(id) != null){
                Database.getInstance().usuarioDeleteById(id);
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
