package com.asouza.alurachallenge.model.resources;

import com.asouza.alurachallenge.model.entities.Videos;
import com.asouza.alurachallenge.model.services.VideosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideosResource {
    private final VideosService videosService;


    @GetMapping
    public ResponseEntity<List<Videos>> retornarTodosVideos(){
        List<Videos> todosVideos = videosService.todosVideos();
        return ResponseEntity.ok().body(todosVideos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videos> buscarPeloId(@PathVariable Long id){
        Videos videos = videosService.buscarPeloId(id);
        return ResponseEntity.ok().body(videos);
    }

    @PostMapping
    public ResponseEntity<Videos> criar(@RequestBody Videos videos){
        Videos vd = new Videos();
        vd.setTitulo(videos.getTitulo());
        vd.setDescricao(videos.getDescricao());
        vd.setUrl(videos.getUrl());
        Videos videos1 = videosService.criarVideo(vd);
        return ResponseEntity.ok().body(videos1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videos> atualizar(@PathVariable Long id, @RequestBody Videos videos){
        videos = videosService.atualizar(id, videos);
        return ResponseEntity.ok(videos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Videos> deletar(@PathVariable Long id){
        videosService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
