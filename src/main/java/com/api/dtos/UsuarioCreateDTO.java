package com.api.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record UsuarioCreateDTO(
        @NotBlank(message = "O nome do usuário é obrigatório")
        String usuarioNome,

        @NotBlank(message = "O e-mail do usuário é obrigatório")
        @Email(message = "O e-mail do usuário deve ser válido")
        String usuarioEmail,

        @NotBlank(message = "A senha do usuário é obrigatória")
        @Size(min = 6, message = "A senha do usuário deve ter no mínimo 6 caracteres")
        String usuarioSenha
) {
}
