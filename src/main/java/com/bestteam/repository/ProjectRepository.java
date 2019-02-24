package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    public List<Project> getProjectByPi(Long pi);
}
