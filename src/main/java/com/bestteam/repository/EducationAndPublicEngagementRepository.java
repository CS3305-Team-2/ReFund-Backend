package com.bestteam.repository;

import com.bestteam.models.EducationAndPublicEngagement;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EducationAndPublicEngagementRepository extends CrudRepository<EducationAndPublicEngagement, Long> {
    List<EducationAndPublicEngagement> findByUserId(Long userId);
}
