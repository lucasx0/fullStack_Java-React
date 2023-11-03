package br.com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio produto_Repositorio;

    @Autowired
    private RespostaModelo resposta_Modelo;


    //Listar todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return produto_Repositorio.findAll();
    }

    //cadastrar produto
    public ResponseEntity<?> cadastrar(ProdutoModelo produto){
        if(produto.getNome().equals("")){
            resposta_Modelo.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
                            
        }else if(produto.getMarca().equals("")){
            resposta_Modelo.setMensagem("A marca Precisa ser preenchida");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);

        }else{
            return new ResponseEntity<>(produto_Repositorio.save(produto), HttpStatus.OK);
        }
    }

    

}
