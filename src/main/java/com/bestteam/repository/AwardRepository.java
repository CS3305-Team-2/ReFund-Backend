package com.bestteam.repository;

import com.bestteam.models.Award;

import org.springframework.data.repository.CrudRepository;
import com.bestteam.models.AwardIdentity;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AwardRepository extends CrudRepository<Award, AwardIdentity> {
    List<Award> findByAwardIdentityUserId(Long userId);
}
