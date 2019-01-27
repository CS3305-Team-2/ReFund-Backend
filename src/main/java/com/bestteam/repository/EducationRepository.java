package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Education;
import com.bestteam.models.EducationIdentity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository<Education, EducationIdentity> {
    List<Education> findByEducationIdentityUserId(Long userId);
}
