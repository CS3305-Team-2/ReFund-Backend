package com.bestteam.repository;

import com.bestteam.models.Employment;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmploymentRepository extends CrudRepository<Employment, Long> {
    List<Employment> findByUserId(Long userId);
}
