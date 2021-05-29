package br.com.diegosouza.clientes.rest;

import br.com.diegosouza.clientes.model.entity.Usuario;
import br.com.diegosouza.clientes.rest.exception.UsuarioCadastradoException;
import br.com.diegosouza.clientes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> usuarios(){
        return  usuarioService.consultar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){

        try{
            usuarioService.salvar(usuario);
        }
        catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
