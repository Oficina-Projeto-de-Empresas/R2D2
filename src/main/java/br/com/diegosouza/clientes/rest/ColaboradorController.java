package br.com.diegosouza.clientes.rest;

import br.com.diegosouza.clientes.model.entity.Colaborador;
import br.com.diegosouza.clientes.model.entity.Usuario;
import br.com.diegosouza.clientes.rest.exception.UsuarioCadastradoException;
import br.com.diegosouza.clientes.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll() {
        List<Colaborador> list = colaboradorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Long id) {
        Colaborador obj = colaboradorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Colaborador> insert(@RequestBody Colaborador obj) throws UsuarioCadastradoException {
        obj = colaboradorService.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Colaborador> update(@PathVariable Long id, @RequestBody Colaborador user) {
        user = colaboradorService.updateUsuario(id, user);
        return ResponseEntity.ok().body(user);
    }
}
