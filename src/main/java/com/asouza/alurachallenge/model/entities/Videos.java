package com.asouza.alurachallenge.model.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O campo titulo é obrigatório.")
    private String titulo;
    @NotEmpty(message = "O campo descricao é obrigatório.")
    private String descricao;
    @NotEmpty(message = "O campo url é obrigatório.")
    private String url;
}
