package br.com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio produto_Repositorio;


    //Listar todos os produtos
    public Iterable<ProdutoModelo> listar(){
        return produto_Repositorio.findAll();
    }
}
