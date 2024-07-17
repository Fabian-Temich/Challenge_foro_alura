package com.challenge_foroalura.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class ControllerTopicos {
    @Autowired
    private ServicesTopicos servicesTopicos;

    @PostMapping
    public ResponseEntity<Topicos> registrarTopico(@RequestBody Topicos request) {
        Topicos topicos = this.servicesTopicos.registrarTopicos(request);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Topicos>> listTopicos() {
        ArrayList<Topicos> arrayList = (ArrayList<Topicos>) this.servicesTopicos.listTopicos();
        return ResponseEntity.ok(arrayList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getTopicos(@PathVariable("id") Long id) {
        Optional<Topicos> topicos = this.servicesTopicos.getTopicos(id);
        if (topicos == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(topicos);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Topicos> updateTopicos(@PathVariable("id") Long id, @RequestBody Topicos request) {
        Topicos topicos = this.servicesTopicos.updateTopicos(id, request);
        if (topicos == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(topicos);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteTopicos(@PathVariable("id") Long id) {
        boolean deleted = this.servicesTopicos.deleteTopicos(id);
        if (deleted) {
            return ResponseEntity.ok(id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
