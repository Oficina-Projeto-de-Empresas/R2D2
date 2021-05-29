package br.com.diegosouza.clientes.service;

import br.com.diegosouza.clientes.model.entity.Produto;
import br.com.diegosouza.clientes.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(Math.toIntExact(id));
        return obj.get();
    }

    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Integer id) {
        Produto obj = findById(id);
        produtoRepository.delete(obj);
    }

    public Produto inventario(Long id, Integer quantidade) {
        Produto prod = produtoRepository.getOne(Math.toIntExact(id));
        prod.setQuantidade(quantidade);
        produtoRepository.save(prod);
        return prod;
    }

    public Produto updateProduto(Integer id, Produto produto) {
        Produto user = produtoRepository.getOne(Math.toIntExact(id));

        user.setNome(produto.getNome());
        user.setCor(produto.getCor());
        user.setTamanho(produto.getTamanho());
        user.setMarca(produto.getMarca());
        user.setCategoria(produto.getCategoria());
        user.setDescricao(produto.getDescricao());
        user.setImagem(produto.getImagem());


        return produtoRepository.save(user);
    }
}
