package com.bestteam.repository;

import java.util.List;

import com.bestteam.models.HostInstitution;
import com.bestteam.models.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostInstitutionRepository extends CrudRepository<HostInstitution, Long> {
    @Query(
        value=" select proj.id, proj.name from Project as proj join TeamMember as team on team.project_id = proj.id join User as user on team.user_id = user.id join HostInstitution as host on user.host_institution_id = host.id where team.role = 'PI' and host.id = ?1",
        nativeQuery=true)
    List<Object[]> getProjectsByHostInstitution(Long hostInstitution);
}
