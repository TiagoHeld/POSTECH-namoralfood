package com.namoralfood.api.domain.usuario.dto;

import com.namoralfood.api.domain.endereco.model.Endereco;
import com.namoralfood.api.domain.usuario.model.Usuario;

import java.util.Date;

public record DadosDetalhamentoUsuario(Long id, String nome, String email, String login, Date dataUltimaAtualizacao, TipoUsuario tipo, Endereco endereco) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getLogin(), usuario.getDataUltimaAlteracao(), usuario.getTipo(), usuario.getEndereco());
    }
}
