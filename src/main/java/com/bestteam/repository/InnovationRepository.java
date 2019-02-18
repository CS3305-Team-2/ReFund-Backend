package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Innovation;
import com.bestteam.models.InnovationIdentity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InnovationRepository extends CrudRepository<Innovation, InnovationIdentity> {
    List<Innovation> findByInnovationIdentityUserId(Long userId);
}
