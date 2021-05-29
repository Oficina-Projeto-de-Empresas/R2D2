package br.com.diegosouza.clientes.rest.exception;

public class UsuarioCadastradoException extends Exception{

    public UsuarioCadastradoException(String login){
        super("Usuário já cadastrado para o login" + login);
    }
}
