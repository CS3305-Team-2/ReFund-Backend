package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Presentation;
import com.bestteam.models.PresentationIdentity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, PresentationIdentity> {
    List<Presentation> findByPresentationIdentityUserId(Long userId);
}
