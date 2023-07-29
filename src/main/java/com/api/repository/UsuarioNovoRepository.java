package com.api.repository;

import com.api.model.UsuarioNovoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioNovoRepository extends JpaRepository<UsuarioNovoModel, Integer> {

    UserDetails findByusuarioEmail(String usuarioEmail);

    UsuarioNovoModel findByUsuarioEmail(String usuarioEmail);

    UsuarioNovoModel findByUsuarioId(Integer usuarioId);

}
