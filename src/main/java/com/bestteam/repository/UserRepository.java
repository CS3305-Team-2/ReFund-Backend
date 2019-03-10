package com.bestteam.repository;

import java.util.Optional;

import com.bestteam.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByOrcid(String orcid);

    public boolean existsByOrcid(String orcid);

    public Optional<User> findByEmail(String email);

    public boolean existsByEmail(String email);

    // @Query(value="SELECT p.proposal_id FROM User AS u JOIN ProposalReviews AS p ON u.id = p.user_id WHERE user_id = ?1", nativeQuery=true)
    public List<Long> getProposalIdFromProposalReviews(Long userId);
}
