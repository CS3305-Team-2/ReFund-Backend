package com.bestteam.repository;

import com.bestteam.models.Grant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantRepository extends CrudRepository<Grant, Long> {}
