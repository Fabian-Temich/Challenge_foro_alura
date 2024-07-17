package com.challenge_foroalura.usuarios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private Services services;

    @GetMapping

    public ResponseEntity<ArrayList<Usuario>>listUsuarios(){
        ArrayList<Usuario> arrayList = (ArrayList<Usuario>) this.services.listUsuarios();
        return ResponseEntity.ok(arrayList);
    }
}
