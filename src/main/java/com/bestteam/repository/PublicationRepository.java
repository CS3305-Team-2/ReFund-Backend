package com.bestteam.repository;

import com.bestteam.models.Publication;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Long> {
    List<Publication> findByUserId(Long userId);
}
