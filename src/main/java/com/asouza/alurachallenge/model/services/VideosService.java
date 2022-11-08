package com.asouza.alurachallenge.model.services;

import com.asouza.alurachallenge.model.entities.Videos;
import com.asouza.alurachallenge.model.repositories.VideosRepository;
import com.asouza.alurachallenge.model.services.exceptions.CampoObrigatorioException;
import com.asouza.alurachallenge.model.services.exceptions.ResourceNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideosService {
    private final VideosRepository videosRepository;

    public List<Videos> todosVideos() {
        return videosRepository.findAll();
    }

    public Videos buscarPeloId(Long id) {
        try{
            Optional<Videos> byId = videosRepository.findById(id);
            return byId.get();
        }catch (NoSuchElementException ex){
            throw new ResourceNotFoundException(id);
        }
    }

    public Videos criarVideo(Videos video) {
        try{
            return videosRepository.save(video);
        }catch (RuntimeException e){
            throw new CampoObrigatorioException(e.getMessage());
        }
    }

    public Videos atualizar(Long id, Videos videos) {
        try {
            Videos entity = videosRepository.getReferenceById(id);
            updateData(entity, videos);
            return videosRepository.save(entity);
        }catch (EntityNotFoundException ex){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Videos entity, Videos videos) {
        entity.setTitulo(videos.getTitulo());
        entity.setDescricao(videos.getDescricao());
        entity.setUrl(videos.getUrl());


    }

    public void deletar(Long id) {
        Optional<Videos> byId = videosRepository.findById(id);
        if (byId.isPresent()){
            videosRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(id);
        }

    }
}
