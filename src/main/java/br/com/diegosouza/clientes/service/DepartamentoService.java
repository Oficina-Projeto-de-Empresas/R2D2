package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Departamento;
import br.com.diegosouza.clientes.model.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepositorio;

    public List<Departamento> findAll() {
        return departamentoRepositorio.findAll();
    }

    public Departamento findById(Long id) {
        Optional<Departamento> obj = departamentoRepositorio.findById(Math.toIntExact(id));
        return obj.get();
    }

    public Departamento insert(Departamento usuario) {
        return departamentoRepositorio.save(usuario);
    }

    public void delete(Long id) {
        Departamento obj = findById(id);
        departamentoRepositorio.delete(obj);
    }

    public Departamento updateDepartamento(Long id, Departamento departamento) {
        Departamento user = departamentoRepositorio.getOne(Math.toIntExact(id));

        user.setNome(departamento.getNome());

        return departamentoRepositorio.save(user);
    }
}
