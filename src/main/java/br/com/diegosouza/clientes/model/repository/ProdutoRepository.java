package br.com.diegosouza.clientes.model.repository;

import br.com.diegosouza.clientes.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
