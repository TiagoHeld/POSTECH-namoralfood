package com.namoralfood.api.domain.usuario.dto;

import com.namoralfood.api.domain.usuario.model.Usuario;

public record SenhaAlterada (Long id, String login, String senha) {
    public SenhaAlterada (Usuario usuario, String senhaEmClaro){
        this(usuario.getId(), usuario.getLogin(), senhaEmClaro);
    }
}
