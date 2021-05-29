package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Fornecedor;
import br.com.diegosouza.clientes.model.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor findById(Long id) {
        Optional<Fornecedor> obj = fornecedorRepository.findById(Math.toIntExact(id));
        return obj.get();
    }

    public Fornecedor insert(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void delete(Long id) {
        Fornecedor obj = findById(id);
        fornecedorRepository.delete(obj);
    }

    public Fornecedor updateFornecedor(Long id, Fornecedor fornecedor) {
        Fornecedor user = fornecedorRepository.getOne(Math.toIntExact(id));

        user.setAtivo(fornecedor.getAtivo());
        user.setDocumento(fornecedor.getDocumento());
        user.setNome(fornecedor.getNome());
        user.setTelefone(fornecedor.getTelefone());
        user.setTipo(fornecedor.getTipo());
        user.setEmail(fornecedor.getEmail());

        return fornecedorRepository.save(user);
    }
}
