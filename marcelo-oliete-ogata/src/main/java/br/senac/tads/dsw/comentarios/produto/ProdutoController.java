/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ModelAndView listar() {
        List<Produto> produtos = repository.findAll();
        return new ModelAndView("produtos/lista").addObject("items", produtos);
    }

    @GetMapping("/{id}")
    public ModelAndView mostrarDetalhes(@PathVariable("id") Integer id, RedirectAttributes redirAttr) {
        Optional<Produto> optProduto = repository.findById(id);
        if (optProduto.isEmpty()) {
            redirAttr.addFlashAttribute("msgErro", "Produto com ID " + id + " não achou.");
            return new ModelAndView("redirect:/produtos");
        }
        return new ModelAndView("produtos/detalhes")
                .addObject("item", optProduto.get());
    }

}
