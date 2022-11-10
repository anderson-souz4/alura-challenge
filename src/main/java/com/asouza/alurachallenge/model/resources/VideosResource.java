package com.asouza.alurachallenge.model.resources;

import com.asouza.alurachallenge.model.entities.Video;
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
    public ResponseEntity<List<Video>> retornarTodosVideos(){
        List<Video> todosVideos = videosService.todosVideos();
        return ResponseEntity.ok().body(todosVideos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> buscarPeloId(@PathVariable Long id){
        Video videos = videosService.buscarPeloId(id);
        return ResponseEntity.ok().body(videos);
    }

    @PostMapping
    public ResponseEntity<Video> criar(@RequestBody Video videos){
        Video vd = new Video();
        vd.setTitulo(videos.getTitulo());
        vd.setDescricao(videos.getDescricao());
        vd.setUrl(videos.getUrl());
        Video videos1 = videosService.criarVideo(vd);
        return ResponseEntity.ok().body(videos1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> atualizar(@PathVariable Long id, @RequestBody Video videos){
        videos = videosService.atualizar(id, videos);
        return ResponseEntity.ok(videos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Video> deletar(@PathVariable Long id){
        videosService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
