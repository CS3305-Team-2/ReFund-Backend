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
}