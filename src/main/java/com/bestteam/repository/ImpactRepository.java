package com.bestteam.repository;

import java.util.Optional;

import com.bestteam.models.Impact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpactRepository extends CrudRepository<Impact, Long> {
    public Optional<Impact> findById(Long id);

    public boolean existsById(Long id);
}
