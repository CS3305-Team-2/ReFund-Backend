package com.bestteam.repository;

import com.bestteam.models.AnnualReport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualReportRepository extends CrudRepository<AnnualReport, Long> {
}
