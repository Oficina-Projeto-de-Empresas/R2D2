package br.com.diegosouza.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean ativo;
    private String nome;
    private String tipo;
    private String documento;
    private String telefone;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Movimentacao> listMovimentacao = new ArrayList<>();
}
