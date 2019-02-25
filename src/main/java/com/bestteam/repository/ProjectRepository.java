package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    public List<Project> getProjectByPi(Long pi);

    @Query(
        value=" SELECT projects.* FROM Project AS projects JOIN TeamMember as teammem ON projects.id = teammem.project_id JOIN User AS user ON user.id = teammem.user_id WHERE user.id = ?1 GROUP BY projects.id",
        nativeQuery=true)
    public List<Project> findAllAssociatedProjects(Long userId);
}
