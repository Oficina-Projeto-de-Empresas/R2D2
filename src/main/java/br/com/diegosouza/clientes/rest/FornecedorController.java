package br.com.diegosouza.clientes.rest;

import br.com.diegosouza.clientes.model.entity.Fornecedor;
import br.com.diegosouza.clientes.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;


    @GetMapping
    public ResponseEntity<List<Fornecedor>> findAll(){
        List<Fornecedor> list = fornecedorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        Fornecedor obj = fornecedorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor obj) {
        obj = fornecedorService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fornecedorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor obj) {
        obj = fornecedorService.updateFornecedor(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
