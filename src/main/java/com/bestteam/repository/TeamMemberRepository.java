package com.bestteam.repository;

import com.bestteam.models.TeamMember;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMemberRepository extends CrudRepository<TeamMember, Long> {
    @Query(value="select user_id FROM TeamMember WHERE id = ?1", nativeQuery=true)
    public Long getUserIdFromTeamMemberId(Long teamMemberId);
}
