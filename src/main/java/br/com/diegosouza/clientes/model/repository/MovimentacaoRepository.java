package br.com.diegosouza.clientes.model.repository;

import br.com.diegosouza.clientes.model.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
