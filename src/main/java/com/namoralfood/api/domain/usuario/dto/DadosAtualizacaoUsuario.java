package com.namoralfood.api.domain.usuario.dto;


import com.namoralfood.api.domain.endereco.model.Endereco;

public record DadosAtualizacaoUsuario(
        Long id,
        String nome,
        String email,
        String login,
        TipoUsuario tipo,
        Endereco endereco) {
}
