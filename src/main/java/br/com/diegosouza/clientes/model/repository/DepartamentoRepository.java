package br.com.diegosouza.clientes.model.repository;

import br.com.diegosouza.clientes.model.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
