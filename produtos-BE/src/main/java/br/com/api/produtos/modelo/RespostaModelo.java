package br.com.api.produtos.modelo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component // faz utilizar a injecao de dependencia
@Getter
@Setter
public class RespostaModelo {
    
    private String mensagem;
}
