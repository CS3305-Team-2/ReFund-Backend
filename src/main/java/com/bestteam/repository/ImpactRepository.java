package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Impact;
import com.bestteam.models.ImpactIdentity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpactRepository extends CrudRepository<Impact, ImpactIdentity> {
    List<Impact> findByImpactIdentityUserId(Long userId);
}
