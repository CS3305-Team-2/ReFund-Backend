package com.bestteam.repository;

import com.bestteam.models.Grants;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantsRepository extends CrudRepository<Grants, Long> {}
