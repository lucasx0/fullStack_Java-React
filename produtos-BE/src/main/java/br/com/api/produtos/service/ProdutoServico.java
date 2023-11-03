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
    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo produto, String acao){

        if(produto.getNome().equals("")){
            resposta_Modelo.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
                            
        }else if(produto.getMarca().equals("")){
            resposta_Modelo.setMensagem("A marca Precisa ser preenchida");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);

        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<>(produto_Repositorio.save(produto), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(produto_Repositorio.save(produto), HttpStatus.OK);
            }
        }
    }

    // deletar

    public ResponseEntity<?> deletar(int codigo){
        if(produto_Repositorio.countByCodigo(codigo) == 0){
            resposta_Modelo.setMensagem("Codigo informado não existe");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
        }else{
            ProdutoModelo modelo = produto_Repositorio.findByCodigo(codigo);
            produto_Repositorio.delete(modelo);
            resposta_Modelo.setMensagem("Item deletado com Sucesso");

            return new ResponseEntity<>(resposta_Modelo, HttpStatus.OK);
        }
    }

 

    //Metodo editar
    public ResponseEntity<?> editar (ProdutoModelo produtoModelo){
        if(produto_Repositorio.countByCodigo(produtoModelo.getCodigo()) == 0){
            resposta_Modelo.setMensagem("Codigo Informado não existe");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
        }else if(produtoModelo.getNome().equals("")){
            resposta_Modelo.setMensagem("É necessario informar o nome");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
        }else if(produtoModelo.getMarca().equals("")){
            resposta_Modelo.setMensagem("É necessario informar a Marca");
            return new ResponseEntity<>(resposta_Modelo, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(produto_Repositorio.save(produtoModelo), HttpStatus.OK);
        }
    }

}
