package com.api.dtos;

public class UsuarioGetDTO {
    Integer UsuarioId;
    String UsuarioNome;
    String UsuarioEmail;
    String UsuarioAdmin;


    public UsuarioGetDTO(Integer usuarioId, String usuarioNome, String usuarioEmail,String usuarioAdmin) {
        UsuarioId = usuarioId;
        UsuarioNome = usuarioNome;
        UsuarioEmail = usuarioEmail;
        UsuarioAdmin = usuarioAdmin;

    }

    public Integer getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        UsuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return UsuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        UsuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return UsuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        UsuarioEmail = usuarioEmail;
    }

    public String getUsuarioAdmin() {
        return UsuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        UsuarioAdmin = usuarioAdmin;
    }

}
