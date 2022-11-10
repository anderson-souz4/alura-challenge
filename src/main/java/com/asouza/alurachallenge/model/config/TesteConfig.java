package com.asouza.alurachallenge.model.config;

import com.asouza.alurachallenge.model.repositories.VideosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TesteConfig implements CommandLineRunner {
    private final VideosRepository videosService;

    @Override
    public void run(String... args) throws Exception {
//        Videos v1 = new Videos(null, "Iniciando com PHP", "Primeiros passos", "http://youtube.com/iniciandoComPh");
//        Videos v2 = new Videos(null, "Programação OO", "Orientação a Objetos", "http://youtube.com/objetos");
//        Videos v3 = new Videos(null, "Python para DEV's", "Programe com Python", "http://youtube.com/python");
//        videosService.saveAll(Arrays.asList(v1,v2,v3));



    }
    }
