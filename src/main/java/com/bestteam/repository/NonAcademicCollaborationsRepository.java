package com.bestteam.repository;

import com.bestteam.models.NonAcademicCollaborations;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NonAcademicCollaborationsRepository extends CrudRepository<NonAcademicCollaborations, Long> {
    List<NonAcademicCollaborations> findByUserId(Long userId);
}
