package com.api.controller;

import com.api.config.security.TokenService;
import com.api.dtos.BodyRefreshDTO;
import com.api.dtos.DadosAutenticacao;
import com.api.dtos.TokenDTO;
import com.api.model.UsuarioNovoModel;
import com.api.repository.UsuarioNovoRepository;
import com.api.service.AutenticacaoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    UsuarioNovoRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AutenticacaoService service;
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados, HttpServletResponse response) {
        var authenticationtoken = new UsernamePasswordAuthenticationToken(dados.usuarioEmail(), dados.usuarioSenha());
        var authentication = manager.authenticate(authenticationtoken);

        var tokenJWT = tokenService.gerarToken((UsuarioNovoModel) authentication.getPrincipal());
        var refresh = tokenService.gerarRefreshToken((UsuarioNovoModel) authentication.getPrincipal());
        var user = repository.findByUsuarioEmail(dados.usuarioEmail());

        user.setUsuarioRefreshToken(refresh);

        var token = new TokenDTO(tokenJWT, refresh);

        Gson gson = new Gson();

        String json = gson.toJson(token);

        return ResponseEntity.ok(json);
    }

    @PostMapping("refresh")
    public ResponseEntity gerarToken(@RequestBody BodyRefreshDTO body) {
        var accessToken = tokenService.UseRefresh(body.getRefreshToken(), body.getEmail());
        Gson gson = new Gson();

        String json = gson.toJson(accessToken);
        return ResponseEntity.ok(json);
    }
}
