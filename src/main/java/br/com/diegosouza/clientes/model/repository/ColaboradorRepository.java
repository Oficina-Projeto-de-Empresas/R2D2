package br.com.diegosouza.clientes.model.repository;

import br.com.diegosouza.clientes.model.entity.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    Optional<Object> findByUsername(String username);

    boolean existsByUsername(String username);
}
