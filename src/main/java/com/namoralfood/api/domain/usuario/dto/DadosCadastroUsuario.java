package com.namoralfood.api.domain.usuario.dto;


import com.namoralfood.api.domain.endereco.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosCadastroUsuario (
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String login,
        @NotBlank
        String senha,
        @NotNull
        @Valid
        Endereco endereco,
        @NotNull
        TipoUsuario tipo
) {
}
