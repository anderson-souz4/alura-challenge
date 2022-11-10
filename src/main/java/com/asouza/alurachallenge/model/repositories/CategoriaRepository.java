package com.asouza.alurachallenge.model.repositories;

import com.asouza.alurachallenge.model.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
