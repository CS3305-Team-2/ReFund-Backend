package com.bestteam.repository;

import com.bestteam.models.Proposal;
import com.bestteam.helpers.ProposalStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long> {
    List<Proposal> findByStatus(ProposalStatus status);
}
