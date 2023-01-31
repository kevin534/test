package com.example.gestionseriews.controllers;

import com.example.gestionseriews.models.Saison;
import com.example.gestionseriews.models.Serie;
import com.example.gestionseriews.repositories.SaisonRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/saison")
public class SaisonController {

    private final SaisonRepository saisonRepository;

    public SaisonController(SaisonRepository saisonRepository) {
        this.saisonRepository = saisonRepository;
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello welcome in my API REST Saison";
    }

    //TODO: créer un Saison
    @PostMapping("/create/{id}")
    public ResponseEntity<Saison> saveSaison(@PathVariable(name = "id") Serie serie,@Valid @RequestBody Saison saison, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, bindingResult.toString());
        }
        else{
            saison.setSerie(serie);
            saisonRepository.save(saison);
            return  new ResponseEntity<>(saison,HttpStatus.CREATED);
        }
    }
    //TODO: réchercher tous les saisons
    @GetMapping("/getAll")
    public List<Saison> findAll(){
        return saisonRepository.findAll();
    }
    //TODO: réchercher un saison by id
    @GetMapping("/{id}")
    List<Saison> getAll(@PathVariable(name = "id", required = false) Serie serie){
        if(serie == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Serie Introuvable");
        }
        else {
            return saisonRepository.findBySerieId(serie.getId());
        }
    }
}
