package com.bestteam.repository;

import com.bestteam.models.TeamMember;
import com.bestteam.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
    //public Optional<TeamMember> getTeamMemberByProjectId(Long projectId);

    @Query(value="select user.* from User as user JOIN TeamMember as team ON user.id = team.user_id WHERE team.id = ?1", nativeQuery=true)
    public User getUserFromTeamMemberId(Long teamMemberId);
}
