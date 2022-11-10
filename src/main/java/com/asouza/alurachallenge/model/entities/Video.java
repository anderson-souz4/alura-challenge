package com.asouza.alurachallenge.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = "video")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O campo titulo é obrigatório.")
    private String titulo;
    @NotEmpty(message = "O campo descricao é obrigatório.")
    private String descricao;
    @NotEmpty(message = "O campo url é obrigatório.")
    private String url;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
