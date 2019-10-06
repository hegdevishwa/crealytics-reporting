package com.crealytics.reporting.configurations;


import com.crealytics.reporting.dao.ReportRepository;
import com.crealytics.reporting.domain.Report;
import com.crealytics.reporting.parser.CSVParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Populate H2 database with the values.
 */
@Component
public class H2DBConfig {

    @Resource
    ReportRepository reportRepository;

    /**
     * Populates H2 DB with the values read form the input file
     * @throws IOException
     */
    @PostConstruct
    public void config() throws IOException {
        List<Report> reports = CSVParser.parse(new ClassPathResource("2018_01_report.csv").getFile());
        reports.forEach(report -> report.setMonth(1));
        reportRepository.saveAll(reports);
    }
}
