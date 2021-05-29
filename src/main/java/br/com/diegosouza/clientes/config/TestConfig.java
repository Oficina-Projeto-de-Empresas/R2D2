package br.com.diegosouza.clientes.config;


import br.com.diegosouza.clientes.model.entity.*;
import br.com.diegosouza.clientes.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;


    @Override
    public void run(String... args) throws Exception {

        Departamento d1 = new Departamento(null,"Fiscal", null);
        Departamento d2 = new Departamento(null, "Financeiro", null);
        Departamento d3 = new Departamento(null, "Compras", null);
        Departamento d4 = new Departamento(null, "Gerência", null);
        departamentoRepository.saveAll(Arrays.asList(d1,d2,d3, d4));

        Colaborador c1 = new Colaborador(null, true, "Gerente", "","gerente","(11)-99999-9999", "gerente","123456", d4);
        colaboradorRepository.save(c1);


        Produto p1 = new Produto(null,"Camisa DBZ", "Vermelho", "M", "DBZ", 0, "Animes", "Camisa do Goku SSJ 3",                null, null);
        Produto p2 = new Produto(null,"Camisa Naruto", "Branco", "P", "Naruto", 0,"Animes", "Camisa do Madara Uchila",
                null, null);
        Produto p3 = new Produto(null,"Camisa DBZ", "Branco", "G", "DBZ", 0, "Animes", "Camisa do Vegeta SSJ 3", null, null);
        Produto p4 = new Produto(null,"Camisa DBZ", "Vermelho", "M", "DBZ", 0, "Animes",  "Camisa do Majin Boo ",null, null);
        Produto p5 = new Produto(null,"Camisa DBZ", "Branco", "M", "DBZ", 0, "Animes", "Camisa do Cell",null, null);
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        Fornecedor f1 = new Fornecedor(null, true, "Venda a clientes", "CNPJ", "00000000000", "0000000000" ,"vendas@gmail.com", null);
        Fornecedor f2 = new Fornecedor(null, true, "Inventário", "CNPJ", "00000000000", "0000000000" ,"inventario@gmail.com", null);
        Fornecedor f5 = new Fornecedor(null, true, "Anime Industria", "CNPJ", "123123123000110", "1199998888" ,"anime@gmail.com", null);
        Fornecedor f6 = new Fornecedor(null, true, "Geek Industria", "CNPJ", "456456456000180", "1177776666" ,"geek@gmail.com", null);
        Fornecedor f3 = new Fornecedor(null, true, "Fan Industria", "CNPJ", "678678678000198", "1166665555" ,"fan@gmail.com", null);
        Fornecedor f4 = new Fornecedor(null, true, "New Japan Industria", "CNPJ", "534534534", "1166665555" ,"newjapan@newjapan.com.br",null);


        fornecedorRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5,f6));

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        Calendar cal4 = Calendar.getInstance();
        Calendar cal5 = Calendar.getInstance();
        Calendar cal6 = Calendar.getInstance();

        cal1.set(2021,00,01);
        cal2.set(2021,01,01);
        cal3.set(2021,02,01);
        cal4.set(2021,03,01);
        cal5.set(2021,04,01);
        cal6.set(2021,05,01);

        Movimentacao m6 = new Movimentacao(null, f3, p1 , cal6.getTime(), "Compra do fornecedor", 5, 5.0, 75.00 );
        p1.setQuantidade(5); produtoRepository.save(p1);

        Movimentacao m2 = new Movimentacao(null, f6, p2 , cal2.getTime(), "Compra do fornecedor", 2, 5.0, 10.00 );
        p2.setQuantidade(p2.getQuantidade() + 2); produtoRepository.save(p2);

        Movimentacao m3 = new Movimentacao(null, f5, p3 , cal3.getTime(), "Compra do fornecedor", 10, 5.0, 10.00 );
        p3.setQuantidade(p3.getQuantidade() +10) ;produtoRepository.save(p3);

        Movimentacao m1 = new Movimentacao(null, f6, p1, cal1.getTime(), "Compra do fornecedor", 2, 5.0, 10.00 );
        p1.setQuantidade(p1.getQuantidade() +2);produtoRepository.save(p1);

        Movimentacao m4 = new Movimentacao(null, f4, p1 , cal4.getTime(), "Compra do fornecedor", 3, 5.0, 15.00 );
        p1.setQuantidade(p1.getQuantidade()+3);produtoRepository.save(p1);

        Movimentacao m5 = new Movimentacao(null, f3, p2, cal5.getTime(), "Compra do fornecedor", 4, 5.0, 60.00 );
        p2.setQuantidade(p2.getQuantidade()+ 4); produtoRepository.save(p2);

        Movimentacao m7 = new Movimentacao(null, null, p1, cal1.getTime(), "Venda", -2, 50.00, 100.00);
        p1.setQuantidade(p1.getQuantidade()-2); produtoRepository.save(p1);

        Movimentacao m8 = new Movimentacao(null, null, p2, cal2.getTime(), "Venda", -3, 45.00, 135.00);
        p2.setQuantidade(p2.getQuantidade() -3); produtoRepository.save(p2);

        Movimentacao m9 = new Movimentacao(null, null, p3, cal6.getTime(), "Venda", -4, 40.00, 160.00);
        p3.setQuantidade(p3.getQuantidade()- 4); produtoRepository.save(p1);

        Movimentacao m10 = new Movimentacao(null, null, p3, cal5.getTime(), "Venda", -5, 30.00, 150.00);
        p3.setQuantidade(p3.getQuantidade() -5); produtoRepository.save(p3);

        Movimentacao m11 = new Movimentacao(null, null, p1, cal3.getTime(), "Venda", -6, 25.00, 150.00);
        p1.setQuantidade(p1.getQuantidade() - 6); produtoRepository.save(p1);

        Movimentacao m12 = new Movimentacao(null, null, p2, cal4.getTime(), "Venda", -1, 50.00, 50.00);
        p2.setQuantidade(p2.getQuantidade() -1); produtoRepository.save(p2);


        movimentacaoRepository.saveAll(Arrays.asList( m3, m5, m2, m6, m4,m1,m7, m8, m9, m10, m11, m12));





    }
}
