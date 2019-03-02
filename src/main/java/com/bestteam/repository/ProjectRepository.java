package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Query(
        value="SELECT projects.* FROM Project AS projects JOIN TeamMember as teammem ON projects.id = teammem.project_id JOIN User AS user ON user.id = teammem.user_id WHERE user.id = ?1 GROUP BY projects.id",
        nativeQuery=true)
    public List<Project> findAllAssociatedProjects(Long userId);

    @Query(
        value="SELECT proj.* FROM Project AS proj JOIN TeamMember AS teammem ON proj.id = teammem.project_id JOIN User AS user on teammem.user_id = user.id WHERE teammem.role = 'PI' AND user.id = ?1",
        nativeQuery=true)
    public List<Project> findAllProjectsForPI(Long piId);

    @Query(
        value="SELECT teammem.id FROM TeamMember AS teammem JOIN Project AS p ON p.id = teammem.project_id WHERE p.id = ?1 AND teammem.role = 'PI'",
        nativeQuery=true)
    public Long getPITeamMemberIdFromProjectId(Long projectId);
}
