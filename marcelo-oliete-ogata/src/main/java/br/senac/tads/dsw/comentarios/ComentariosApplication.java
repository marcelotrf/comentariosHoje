package br.senac.tads.dsw.comentarios;

import br.senac.tads.dsw.comentarios.comentario.Comentario;
import br.senac.tads.dsw.comentarios.produto.Produto;
import br.senac.tads.dsw.comentarios.produto.ProdutoRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class ComentariosApplication implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComentariosApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (produtoRepository.count() == 0) {
            Produto a = new Produto("Leite", "Descrição leite", new BigDecimal("3.53"), "/img/produto1.jpg");
            Produto b = new Produto("Pizza Mussarela", "Descrição pizza", new BigDecimal("49.67"), "/img/produto2.jpg");
            produtoRepository.save(new Produto("Leite", "Descrição leite", new BigDecimal("3.53"), "/img/produto1.jpg"));
            produtoRepository.save(new Produto("Pizza Mussarela", "Descrição pizza", new BigDecimal("49.67"), "/img/produto2.jpg"));
        }
    }

}
