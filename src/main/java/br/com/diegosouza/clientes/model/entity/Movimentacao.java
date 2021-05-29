package br.com.diegosouza.clientes.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "produto")
    private Produto produto;

    private Date dataMovimentacao;
    private String movimentacaoTipo;
    private Integer quantidade;
    private Double valor;
    private Double valorTotal;


}
