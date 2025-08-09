package com.namoralfood.api.domain.endereco.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
     @NotBlank
     private String logradouro;
     @NotBlank
     private String bairro;
     @NotBlank
     @Pattern(regexp = "\\d{8}")
     private String cep;
     @NotBlank
     private String cidade;
     @NotBlank
     private String uf;
     @NotBlank
     private String numero;
     private String complemento;

     public void atualizarInformacoes(Endereco dados) {
          if (dados.logradouro != null) {
               setLogradouro(dados.logradouro);;
          }

          if (dados.bairro != null) {
               setBairro(dados.bairro);;
          }

          if (dados.cep != null) {
               setCep(dados.cep);
          }

          if (dados.uf != null) {
               setUf(dados.uf);
          }

          if (dados.cidade != null) {
               setCidade(dados.cidade);
          }

          if (dados.numero != null) {
               setNumero(dados.numero);
          }

          if (dados.complemento != null) {
               setComplemento(dados.complemento);
          }
     }
}
