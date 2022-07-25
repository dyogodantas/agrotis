package com.agrotis.controller;

import com.agrotis.entidade.Profissional;
import com.agrotis.repositorio.ProfissionalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProfissionalController {

    @Autowired
    private ProfissionalRepositorio rep;

    @GetMapping
    @RequestMapping(value = "/profissional", method = RequestMethod.GET)
    //Buscando todos os profissionais
    public Iterable<Profissional> listar() {
        return rep.findAll();
    }

    @RequestMapping(value = "/profissional", method =  RequestMethod.PUT)
    // Inserindo ou atualizando um profissional
    public Profissional inserirOuAtualizar(@RequestBody Profissional prof){
        return rep.save(prof);
    }

    @RequestMapping(value = "/profissional/{id}", method =  RequestMethod.GET)
    // Listando um profissional pelo ID
    public ResponseEntity<Profissional> listarPorId(@PathVariable(value = "id") int id){
        Optional<Profissional> oldProf = rep.findById(id);
        if (oldProf.isPresent()){
            return new ResponseEntity<Profissional>(oldProf.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/profissional/{id}", method = RequestMethod.DELETE)
    // Apagando um profissional
    public ResponseEntity<Object> apagar(@PathVariable(value = "id") int id)
    {
        Optional<Profissional> prof = rep.findById(id);
        if(prof.isPresent()){
            rep.delete(prof.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
