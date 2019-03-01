package com.bestteam.repository;

import com.bestteam.models.Awards;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AwardsRepository extends CrudRepository<Awards, Long> {
    List<Awards> findByUserId(Long userId);
}
