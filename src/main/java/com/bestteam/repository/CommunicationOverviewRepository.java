package com.bestteam.repository;

import com.bestteam.models.CommunicationOverview;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommunicationOverviewRepository extends CrudRepository<CommunicationOverview, Long> {
    List<CommunicationOverview> findByUserId(Long userId);
}
