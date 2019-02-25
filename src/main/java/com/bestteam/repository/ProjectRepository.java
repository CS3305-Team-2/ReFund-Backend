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
        value="SELECT projects.* FROM Project AS projects JOIN MemberToProject AS memtoproj ON memtoproj.project_id = projects.id JOIN TeamMember AS teammem ON teammem.id = memtoproj.member_id JOIN User AS user ON user.id = teammem.user_id WHERE user.id = ?1 GROUP BY projects.id",
        nativeQuery=true)
    public List<Project> findAllAssociatedProjects(Long userId);
}
