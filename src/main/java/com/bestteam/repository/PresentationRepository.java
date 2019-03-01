package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Presentation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long> {
    List<Presentation> findByUserId(Long userId);
}
