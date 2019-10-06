package com.crealytics.reporting.dao;

import com.crealytics.reporting.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Report repository
 */
public interface ReportRepository extends CrudRepository<Report, Integer> {

    /**
     * Save all reports
     *
     * @param iterable
     * @param <S>
     * @return
     */
    @Override
    <S extends Report> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    List<Report> findAll();

    Report findByMonthAndSite(String month, String site);
}
