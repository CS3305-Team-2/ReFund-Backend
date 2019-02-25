package com.bestteam.repository;

import java.util.Optional;

import com.bestteam.models.TeamMember;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
    //public Optional<TeamMember> getTeamMemberByProjectId(Long projectId);
}
