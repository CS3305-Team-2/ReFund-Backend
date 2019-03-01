package com.bestteam.repository;

import com.bestteam.models.SocietyMembership;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SocietyMembershipRepository extends CrudRepository<SocietyMembership, Long> {
    List<SocietyMembership> findByUserId(Long userId);
}
