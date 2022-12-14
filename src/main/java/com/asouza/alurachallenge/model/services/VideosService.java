package com.asouza.alurachallenge.model.services;

import com.asouza.alurachallenge.model.entities.Video;
import com.asouza.alurachallenge.model.repositories.VideosRepository;
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
public class VideosService {
    private final VideosRepository videosRepository;

    public List<Video> todosVideos() {
        return videosRepository.findAll();
    }

    public Video buscarPeloId(Long id) {
        try{
            Optional<Video> byId = videosRepository.findById(id);
            return byId.get();
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(id);
        }
    }

    public Video criarVideo(Video video) {
        try{
            return videosRepository.save(video);
        }catch (RuntimeException e){
            throw new CampoObrigatorioException(e.getMessage());
        }
    }

    public Video atualizar(Long id, Video videos) {
        try {
            Video entity = videosRepository.getReferenceById(id);
            updateData(entity, videos);
            return videosRepository.save(entity);
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Video entity, Video videos) {
        entity.setTitulo(videos.getTitulo());
        entity.setDescricao(videos.getDescricao());
        entity.setUrl(videos.getUrl());


    }

    public void deletar(Long id) {
        Optional<Video> byId = videosRepository.findById(id);
        if (byId.isPresent()){
            videosRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }

    }
}
