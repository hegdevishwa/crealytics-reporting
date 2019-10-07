package com.crealytics.reporting.configurations;


import com.crealytics.reporting.dao.ReportRepository;
import com.crealytics.reporting.entity.Report;
import com.crealytics.reporting.parser.CSVParser;
import com.crealytics.reporting.services.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * Populate H2 database with the values.
 */
@Component
public class H2DBConfig {

    @Autowired
    ReportRepository reportRepository;
    @Autowired
    ReportingService reportingService;

    /**
     * Populates H2 DB with the values read form the input file
     *
     * @throws IOException
     */
    @PostConstruct
    public void config() throws IOException {
        List<Report> janReports = CSVParser.parse(new ClassPathResource("2018_01_report.csv").getInputStream());
        janReports.forEach(report -> report.setMonth("January"));
        reportingService.generateFullReport(janReports);
        reportRepository.saveAll(janReports);

        List<Report> febReports = CSVParser.parse(new ClassPathResource("2018_02_report.csv").getInputStream());
        febReports.forEach(report -> report.setMonth("February"));
        reportingService.generateFullReport(febReports);
        reportRepository.saveAll(febReports);
    }
}
