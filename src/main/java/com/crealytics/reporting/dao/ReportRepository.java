package com.crealytics.reporting.dao;

import com.crealytics.reporting.domain.Report;
import org.springframework.data.repository.CrudRepository;

/**
 * Report repository
 */
public interface ReportRepository extends CrudRepository<Report, Integer> {

    /**
     * Save all reports
     * @param iterable
     * @param <S>
     * @return
     */
    @Override
    <S extends Report> Iterable<S> saveAll(Iterable<S> iterable);
}
