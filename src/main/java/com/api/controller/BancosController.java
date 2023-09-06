package com.api.controller;

import com.api.config.mapper.interfaces.IMapper;
import com.api.dtos.BancosDiaDTO;
import com.api.model.BancosDiaModel;
import com.api.repository.BancosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("Bancos")
public class BancosController {

    @Autowired
    BancosRepository repository;

    @GetMapping("/{empresaId}")
    public ResponseEntity listarBancos(@PathVariable("empresaId") Integer empresaId) {
        return ResponseEntity.ok(repository.findByEmpresaId(empresaId));
    }

    @PutMapping("/{banco}")
    @Transactional
    public ResponseEntity atualizarBancoDoDia(@PathVariable("banco") Integer conta, @RequestBody BancosDiaDTO bancoAtualizado) {
        if (bancoAtualizado == null) {
            return ResponseEntity.badRequest().build();
        }

        BancosDiaModel banco = repository.findByBancoConta(conta);

        if (banco == null) {
            return ResponseEntity.notFound().build();
        }
        banco = IMapper.INSTANCE.createBancoDTOtoBanco(bancoAtualizado);
        repository.save(banco);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{empresaId}")
    @Transactional
    public ResponseEntity<?> adicionarBanco(@RequestBody BancosDiaDTO dto, @PathVariable Integer empresaId) {

        if (dto == null) {
            return ResponseEntity.badRequest().build();
        }

        BancosDiaModel banco = IMapper.INSTANCE.createBancoDTOtoBanco(dto);

        banco.setEmpresaId(empresaId);

        repository.save(banco);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}")
                .buildAndExpand(banco.getBancoConta()).toUri();

        return ResponseEntity.created(location).body(banco);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarBanco(@PathVariable Integer id) {

        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        var banco = repository.findByBancoConta(id);

        if (banco == null){
            return ResponseEntity.notFound().build();
        }

        repository.delete(banco);


        return ResponseEntity.ok().build();
    }

}
