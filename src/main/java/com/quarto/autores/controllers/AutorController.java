package com.quarto.autores.controllers;

import com.quarto.autores.models.AutorModel;
import com.quarto.autores.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (path = "/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorModel>criarAutor(@RequestBody AutorModel autorModel){
        AutorModel requeste = autorService.criarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requeste.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll(){
        List<AutorModel> requeste = autorService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> findById(@PathVariable Long id){
        AutorModel autorModel = autorService.findById(id);
        return ResponseEntity.ok().body(autorModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }
}
