package com.microsservico.estoque_padaria.Controller;

import com.microsservico.estoque_padaria.Model.Estoque;
import com.microsservico.estoque_padaria.Repository.Estoque_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estoque")
public class Controller_Estoque {
    // http://localhost:8080/estoque/todos
    @Autowired
    private Estoque_DAO dao;

    @GetMapping("/todos")
    public List<Estoque> listaEstoque(){
        return dao.findAll();
    }

    @GetMapping("/listaprodutos")
    public List<Estoque> listaEstoqueProdutos(@RequestParam List<Integer> ids){
        return dao.findAllById(ids);
    }

    @GetMapping("/{produto}")
    public Optional<Estoque> buscaProduto(@PathVariable int produto){  //Optional -> se não encontrar, retorna NULL
        return dao.findById(produto);
    }

    @PostMapping("/vendeu")
    public ResponseEntity<String> atualizarEstoque(@RequestBody List<Estoque> produtoVendido) {
        for (Estoque produto : produtoVendido) {
            Optional<Estoque> optionalProdutoEstoque = dao.findById(produto.getIdProduto());

            if (optionalProdutoEstoque.isPresent()) {
                Estoque produtoEstoque = optionalProdutoEstoque.get();
                produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() - produto.getQuantidade());
                dao.save(produtoEstoque);
            }
        }
        return ResponseEntity.ok("Estoque atualizado com sucesso!");
    }


    @PutMapping("/editar")
    public Estoque editarEstoque(@RequestBody Estoque produto){
        return dao.save(produto);
    }
}
