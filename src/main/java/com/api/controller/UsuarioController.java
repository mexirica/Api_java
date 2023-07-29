package com.api.controller;

import com.api.config.security.HashSenha;
import com.api.model.UsuarioNovoModel;
import com.api.repository.UsuarioNovoRepository;
import com.api.service.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioNovoRepository repository;

    @Autowired
    private HashSenha hash;

    @Autowired
    private DtoService service;


    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody UsuarioNovoModel Usuario) {

        if (Usuario == null) {
            return ResponseEntity.badRequest().build();
        }

        Usuario = hash.HashearSenha(Usuario);

        repository.save(Usuario);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
                .buildAndExpand(Usuario.getusuarioId()).toUri();

        return ResponseEntity.created(location).body(Usuario);
    }

    @GetMapping
    public ResponseEntity get() {
        var usuarios = repository.findAll();

        var users = service.GetUserToDTO(usuarios);

        return ResponseEntity.ok(users);
    }

    @PutMapping("/{Id}")
    public ResponseEntity alterar(@PathVariable Integer Id, @RequestBody UsuarioNovoModel model) {

        if (model == null) {
            return ResponseEntity.badRequest().build();
        }

        var user = repository.findByUsuarioId(Id);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        if (model.getusuarioSenha() != null) {
            user = model;

            var UpdateUser = hash.HashearSenha(user);

            repository.save(UpdateUser);

            return ResponseEntity.noContent().build();

        }

        user = service.AtualizarUsuario(user, model);

        repository.save(user);

        return ResponseEntity.noContent().build();
    }
}



