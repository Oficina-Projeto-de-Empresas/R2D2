package br.com.diegosouza.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Departamento {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "departamento")
    private List<Colaborador> listUsuario = new ArrayList<>();

}