package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Impact;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpactRepository extends CrudRepository<Impact, Long> {
    List<Impact> findByUserId(Long userId);
}
