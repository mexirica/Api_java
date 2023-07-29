package com.api.config.security;

import com.api.model.UsuarioNovoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HashSenha {
    @Autowired
    private SecurityConfig hash;

    public UsuarioNovoModel HashearSenha(UsuarioNovoModel usuario) {

        usuario.setusuarioSenha(hash.passwordEncoder().encode(usuario.getusuarioSenha()));
        usuario.setusuarioSenha(usuario.getusuarioSenha());

        return usuario;
    }
}
