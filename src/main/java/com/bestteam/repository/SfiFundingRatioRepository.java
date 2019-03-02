package com.bestteam.repository;

import com.bestteam.models.SfiFundingRatio;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SfiFundingRatioRepository extends CrudRepository<SfiFundingRatio, Long> {
    List<SfiFundingRatio> findByUserId(Long userId);
}
