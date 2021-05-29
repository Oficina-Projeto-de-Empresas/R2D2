package br.com.diegosouza.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Produto {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private String nome;
    private String cor;
    private String tamanho;
    private String marca;
    private Integer quantidade;
    private String categoria;
    private String descricao;
    private String imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<Movimentacao> listMovimentacao = new ArrayList<>();
}
