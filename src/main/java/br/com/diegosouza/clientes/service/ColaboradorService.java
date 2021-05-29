package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Colaborador;
import br.com.diegosouza.clientes.model.repository.ColaboradorRepository;
import br.com.diegosouza.clientes.rest.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService implements UserDetailsService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll(){
        return colaboradorRepository.findAll();
    }

    public Colaborador findByUsername(String username){
        Optional<Object> obj = colaboradorRepository.findByUsername(username);
        return (Colaborador) obj.get();
    }

    public Colaborador findById(Long id) {
        Optional<Colaborador> obj =  colaboradorRepository.findById(Math.toIntExact(id));
        return obj.get();
    }

    public void delete(Long id) {
        Colaborador obj = findById(id);
        colaboradorRepository.delete(obj);
    }

    public Colaborador updateUsuario(Long id, Colaborador usuario) {
        Colaborador user = colaboradorRepository.getOne(Math.toIntExact(id));

        user.setNome(usuario.getNome());
        user.setAtivo(usuario.getAtivo());
        user.setTelefone(usuario.getTelefone());
        user.setDepartamento(usuario.getDepartamento());
        user.setCargo(usuario.getCargo());
        user.setPassword(usuario.getPassword());

        return colaboradorRepository.save(user);
    }

    public Colaborador salvar(Colaborador colaborador ) throws UsuarioCadastradoException {
        boolean existe = colaboradorRepository.existsByUsername(colaborador.getUsername());

        if(existe){
            throw new UsuarioCadastradoException(colaborador.getUsername());
        }
        return colaboradorRepository.save(colaborador);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Colaborador colaborador = (Colaborador) colaboradorRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Login não encontrado."));

        return User
                .builder()
                .username(colaborador.getUsername())
                .password(colaborador.getPassword())
                .roles("USER")
                .build();
    }

}
