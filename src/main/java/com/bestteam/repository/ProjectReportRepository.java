package com.bestteam.repository;

import com.bestteam.models.ProjectReport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectReportRepository extends CrudRepository<ProjectReport, Long> {}