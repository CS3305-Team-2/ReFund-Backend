package com.bestteam.repository;

import com.bestteam.models.ProposalReviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalReviewsRepository extends CrudRepository<ProposalReviews, Long> {}
