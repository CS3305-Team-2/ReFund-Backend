package com.bestteam.repository;

import com.bestteam.models.Employment;

import org.springframework.data.repository.CrudRepository;
import com.bestteam.models.EmploymentIdentity;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmploymentRepository extends CrudRepository<Employment, EmploymentIdentity> {
    List<Employment> findByEmploymentIdentityUserId(Long userId);
}
