package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Innovation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnovationRepository extends CrudRepository<Innovation, Long> {
    List<Innovation> findByUserId(Long userId);
}
