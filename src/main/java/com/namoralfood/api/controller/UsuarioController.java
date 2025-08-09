package com.namoralfood.api.controller;

import com.namoralfood.api.domain.usuario.dto.*;
import com.namoralfood.api.domain.usuario.model.Usuario;
import com.namoralfood.api.domain.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public  ResponseEntity<DadosDetalhamentoUsuario>cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        repository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoUsuario> atualizar(@PathVariable("id") Long id, @RequestBody DadosAtualizacaoUsuario dados) {
        var usuario = repository.getReferenceById(id);
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(@PageableDefault(size = 10, sort={"nome"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> detalhar(@PathVariable("id") Long id) {
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<SenhaAlterada> alterar(@PathVariable("id") Long id, @RequestBody DadosAtualizacaoSenha dados) {
        var usuario = repository.getReferenceById(id);
        String senhaCriptografada = passwordEncoder.encode(dados.senha());

        String senhaAlterada = dados.senha();
        usuario.atualizarSenha(new DadosAtualizacaoSenha(senhaCriptografada));

        return ResponseEntity.ok(new SenhaAlterada(usuario, senhaAlterada));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }


}
