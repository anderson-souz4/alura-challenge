package com.asouza.alurachallenge.model.repositories;

import com.asouza.alurachallenge.model.entities.Videos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideosRepository extends JpaRepository<Videos, Long> {
}
