package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.service.ProdutoServico;


@RestController

public class ProdutoControle {
    
    @Autowired
    private ProdutoServico produtoServico;


    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return produtoServico.listar();
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo produtoModelo){
        return produtoServico.cadastrarAlterar(produtoModelo, "cadastrar");
    }

    @DeleteMapping("/remover/{codig}")
    public ResponseEntity<?> apagar(@PathVariable int codig){
        return produtoServico.deletar(codig);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produtoModelo){
        return produtoServico.cadastrarAlterar(produtoModelo, "alterar");
    }
   
    
}
