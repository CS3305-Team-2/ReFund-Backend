package com.bestteam.repository;

import com.bestteam.models.AcademicCollaborations;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AcademicCollaborationsRepository extends CrudRepository<AcademicCollaborations, Long> {
    List<AcademicCollaborations> findByUserId(Long userId);
}
