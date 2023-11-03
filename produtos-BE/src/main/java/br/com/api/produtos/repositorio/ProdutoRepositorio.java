package br.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.produtos.modelo.ProdutoModelo;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long>{

    int countByCodigo(Long id);
    int countByCodigo(int id);

    ProdutoModelo findByCodigo(int codigo);

    
} 