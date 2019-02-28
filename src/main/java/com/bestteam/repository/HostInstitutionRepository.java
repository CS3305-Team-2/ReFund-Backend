package com.bestteam.repository;

import com.bestteam.models.HostInstitution;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostInstitutionRepository extends CrudRepository<HostInstitution, String> {}
