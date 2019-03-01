package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Education;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {
    List<Education> findByUserId(Long userId);
}
