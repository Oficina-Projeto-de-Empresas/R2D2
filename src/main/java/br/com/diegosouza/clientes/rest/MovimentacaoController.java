package br.com.diegosouza.clientes.rest;

import br.com.diegosouza.clientes.model.entity.Movimentacao;
import br.com.diegosouza.clientes.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoServico;


    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll(){
        List<Movimentacao> list = movimentacaoServico.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "produto/{id}")
    public ResponseEntity<List<Movimentacao>> findMovProdutobyId(@PathVariable Long id) {
        List<Movimentacao> list1 = movimentacaoServico.findMovProdutobyId(Math.toIntExact(id));
        return ResponseEntity.ok().body(list1);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable Long id) {
        Movimentacao obj = movimentacaoServico.findById(Math.toIntExact(id));
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movimentacao> insert(@RequestBody Movimentacao obj) {
        obj = movimentacaoServico.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movimentacaoServico.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Movimentacao> update(@PathVariable Long id, @RequestBody Movimentacao obj) {
        obj = movimentacaoServico.updateMovimentacao(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
