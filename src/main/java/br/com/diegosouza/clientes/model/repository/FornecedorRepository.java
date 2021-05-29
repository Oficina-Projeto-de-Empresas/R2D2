package br.com.diegosouza.clientes.model.repository;

import br.com.diegosouza.clientes.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
