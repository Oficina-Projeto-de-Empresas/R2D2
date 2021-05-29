package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Usuario;
import br.com.diegosouza.clientes.model.repository.UsuarioRepository;
import br.com.diegosouza.clientes.rest.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> consultar(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario ) throws UsuarioCadastradoException {
        boolean existe = usuarioRepository.existsByUsername(usuario.getUsername());

        if(existe){
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Login não encontrado."));


        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
