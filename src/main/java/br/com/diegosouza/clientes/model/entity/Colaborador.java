package br.com.diegosouza.clientes.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Colaborador {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private Boolean ativo;
    private String nome;
    private String sobrenome;
    private String cargo;
    private String telefone;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

}
