package com.bestteam.repository;

import java.util.Optional;

import com.bestteam.models.Presentation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long> {
    public Optional<Presentation> findById(Long id);

    public boolean existsById(Long id);
}
