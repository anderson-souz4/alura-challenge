package com.asouza.alurachallenge.model.services;

import com.asouza.alurachallenge.model.entities.Categoria;
import com.asouza.alurachallenge.model.repositories.CategoriaRepository;
import com.asouza.alurachallenge.model.services.exceptions.CampoObrigatorioException;
import com.asouza.alurachallenge.model.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public List<Categoria> todasCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPeloId(Long id) {
        try{
            Optional<Categoria> byId = categoriaRepository.findById(id);
            return byId.get();
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(id);
        }
    }

    public Categoria criarCategoria(Categoria categoria) {
        try{
            return categoriaRepository.save(categoria);
        }catch (RuntimeException e){
            throw new CampoObrigatorioException(e.getMessage());
        }
    }

    public Categoria atualizar(Long id, Categoria categoria) {
        try {
            Categoria entity = categoriaRepository.getReferenceById(id);
            updateData(entity, categoria);
            return categoriaRepository.save(entity);
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Categoria entity, Categoria categoria) {
        entity.setTitulo(categoria.getTitulo());
        entity.setCor(categoria.getCor());

    }

    public void deletar(Long id) {
        Optional<Categoria> byId = categoriaRepository.findById(id);
        if (byId.isPresent()){
            categoriaRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }

    }


}
