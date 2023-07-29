package com.api.service;

import com.api.dtos.UsuarioGetDTO;
import com.api.model.UsuarioNovoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoService {

    public List<UsuarioGetDTO> GetUserToDTO(List<UsuarioNovoModel> usuarios) {
        var users = new ArrayList<UsuarioGetDTO>();

        for (UsuarioNovoModel user : usuarios) {
            UsuarioGetDTO usuario = new UsuarioGetDTO(user.getusuarioId(), user.getusuarioNome(), user.getusuarioEmail(), user.getusuarioAdmin());
            users.add(usuario);
        }
        return users;
    }

    public UsuarioNovoModel AtualizarUsuario(UsuarioNovoModel antigo, UsuarioNovoModel novo){
        novo.setusuarioSenha(antigo.getusuarioSenha());
        return novo;

    }

}
