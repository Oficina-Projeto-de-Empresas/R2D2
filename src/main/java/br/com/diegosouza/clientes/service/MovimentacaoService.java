package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Movimentacao;
import br.com.diegosouza.clientes.model.entity.Produto;
import br.com.diegosouza.clientes.model.repository.MovimentacaoRepository;
import br.com.diegosouza.clientes.rest.ProdutoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private ProdutoController produtoController;

    @Autowired
    private ProdutoService produtoService;


    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao findById(Integer id) {
        Optional<Movimentacao> obj = movimentacaoRepository.findById(Math.toIntExact(id));
        return obj.get();
    }

    public List<Movimentacao> findMovProdutobyId(Integer id){
        List<Movimentacao> obj = movimentacaoRepository.findAll();
        List<Movimentacao> listaFiltrada = new ArrayList<>();

        obj.forEach((movimentacao) -> {
            if (movimentacao.getProduto().getId() == id) {
                listaFiltrada.add(movimentacao);
            }
        });

        return listaFiltrada;
    }


    public Movimentacao insert(Movimentacao movimentacao) {

        Produto prod = this.produtoService.findById(movimentacao.getProduto().getId());

        if (movimentacao.getMovimentacaoTipo().equals("Inventário")) {
            prod.setQuantidade(movimentacao.getQuantidade());
            this.produtoController.update(prod.getId(), prod);
        }

        else {
            int saldo = prod.getQuantidade();
            prod.setQuantidade(saldo + movimentacao.getQuantidade());
            this.produtoController.update(prod.getId(), prod);
        }
        return movimentacaoRepository.save(movimentacao);

    }



    public void delete(Long id) {
        Movimentacao obj = findById(Math.toIntExact(id));
        movimentacaoRepository.delete(obj);
    }

    public Movimentacao updateMovimentacao(Long id, Movimentacao movimentacao) {
        Movimentacao user = movimentacaoRepository.getOne(Math.toIntExact(id));

        user.setQuantidade(movimentacao.getQuantidade());

        return movimentacaoRepository.save(user);
    }
}
