package com.api.service;

import com.api.repository.UsuarioNovoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioNovoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String UsuarioEmail) throws UsernameNotFoundException {
        return repository.findByusuarioEmail(UsuarioEmail);

    }

    public String recuperarAcessToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }

}
