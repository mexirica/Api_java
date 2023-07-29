package com.api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "Usuarios")
public class UsuarioNovoModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioId")
    private Integer usuarioId;
    @Column(name = "UsuarioNome")
    private String usuarioNome;
    @Email
    @Column(name = "UsuarioEmail")
    private String usuarioEmail;
    @Column(name = "UsuarioSenha")
    private String usuarioSenha;
    @Size(max = 1)
    @Column(name = "UsuarioAdmin")
    private String usuarioAdmin;
    @Column(name = "UsuarioRefreshToken")
    private String usuarioRefreshToken;

    public String getUsuarioRefreshToken() {
        return usuarioRefreshToken;
    }

    public void setUsuarioRefreshToken(String usuarioRefreshToken) {
        this.usuarioRefreshToken = usuarioRefreshToken;
    }


    public Integer getusuarioId() {
        return usuarioId;
    }

    public void setusuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getusuarioNome() {
        return usuarioNome;
    }

    public void setusuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getusuarioEmail() {
        return usuarioEmail;
    }

    public void setusuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getusuarioSenha() {
        return usuarioSenha;
    }

    public void setusuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public String getusuarioAdmin() {
        return usuarioAdmin;
    }

    public void setusuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return usuarioEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

