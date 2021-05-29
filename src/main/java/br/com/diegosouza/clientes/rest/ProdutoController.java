package br.com.diegosouza.clientes.rest;

import br.com.diegosouza.clientes.model.entity.Produto;
import br.com.diegosouza.clientes.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
        obj = produtoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }



    @PutMapping(value="/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto obj) {
        obj = produtoService.updateProduto(id, obj);
        return ResponseEntity.ok().body(obj);
    }



}
