package com.microsservico.estoque_padaria.Controller;

import com.microsservico.estoque_padaria.Model.Estoque;
import com.microsservico.estoque_padaria.Repository.Estoque_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estoque")
public class Controller_Estoque {
    // http://localhost:8080/usuario
    @Autowired
    private Estoque_DAO dao;

    @GetMapping("/todos")
    public List<Estoque> listaEstoque(){
        return (List<Estoque>) dao.findAll();
    }

    @PutMapping("/editar")
    public Estoque editarEstoque(@RequestBody Estoque estoque){
        return dao.save(estoque);
    }
}
