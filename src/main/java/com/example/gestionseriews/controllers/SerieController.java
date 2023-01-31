package com.example.gestionseriews.controllers;

import com.example.gestionseriews.models.Saison;
import com.example.gestionseriews.models.Serie;
import com.example.gestionseriews.repositories.SerieRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/serie")
public class SerieController {
    private final SerieRepository serieRepository;


    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello welcome in my API REST Serie";
    }

    //TODO: créer un Serie
    @PostMapping("/create")
    public ResponseEntity<Serie> saveSerie(@Valid @RequestBody Serie serie, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else{
            serieRepository.save(serie);
            return  new ResponseEntity<>(serie,HttpStatus.CREATED);
        }
    }

    //TODO: modifier un Serie par id
    @PutMapping(value = "/{id}")
    public ResponseEntity<Serie> update(@PathVariable(name = "id" ,required = false) Serie serie, @Valid  @RequestBody Serie serieUpdate, BindingResult bindingResult){
        if(serie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie Introuvable");
        }
        else{
            if(bindingResult.hasErrors()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
            }
            else{
                serieUpdate.setId(serie.getId());
                serieRepository.save(serieUpdate);
                return  new ResponseEntity<>(serieUpdate,HttpStatus.OK);
            }
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOne(@PathVariable(name = "id",required = false) Serie serie)
    {
        if(serie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie Introuvable");
        }
        else{
            serieRepository.delete(serie);
        }
    }

    //TODO: réchercher un serie by id
    @GetMapping("/{id}")
    Serie getOne(@PathVariable(name = "id", required = false) Serie serie){
        if(serie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie Introuvable");
        }
        else {
            return serie;
        }
    }
    //TODO: réchercher tous les series
    @GetMapping("/getAll")
    public List<Serie> findAll(){
        return serieRepository.findAll();
    }
}
