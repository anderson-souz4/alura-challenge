package com.asouza.alurachallenge.model.resources;

import com.asouza.alurachallenge.model.entities.Categoria;
import com.asouza.alurachallenge.model.entities.Video;
import com.asouza.alurachallenge.model.services.CategoriaService;
import com.asouza.alurachallenge.model.services.VideosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaResource {
    private final CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>> retornarTodosVideos(){
        List<Categoria> todosCategorias = categoriaService.todasCategorias();
        return ResponseEntity.ok().body(todosCategorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPeloId(@PathVariable Long id){
        Categoria categorias = categoriaService.buscarPeloId(id);
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria){
        Categoria cat = new Categoria();
        cat.setTitulo(categoria.getTitulo());
        cat.setCor(categoria.getCor());
        Categoria categorias = categoriaService.criarCategoria(cat);
        return ResponseEntity.ok().body(categorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categorias){
        categorias = categoriaService.atualizar(id, categorias);
        return ResponseEntity.ok(categorias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
