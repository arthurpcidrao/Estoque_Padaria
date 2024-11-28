package com.microsservico.estoque_padaria.Repository;

import com.microsservico.estoque_padaria.Model.Estoque;
import org.springframework.data.repository.CrudRepository;

public interface Estoque_DAO extends CrudRepository<Estoque, Integer> {
}
