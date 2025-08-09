package com.namoralfood.api.domain.usuario.dto;

import com.namoralfood.api.domain.usuario.model.Usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String login) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getLogin());
    }
}
