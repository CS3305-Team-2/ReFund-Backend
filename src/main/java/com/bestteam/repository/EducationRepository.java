package com.bestteam.repository;

import com.bestteam.models.Education;
import com.bestteam.models.EducationEmbeddedKey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EducationRepository extends CrudRepository<Education, EducationEmbeddedKey> {}
