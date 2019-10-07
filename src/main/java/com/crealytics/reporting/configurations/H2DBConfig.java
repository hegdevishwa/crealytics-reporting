package com.crealytics.reporting.configurations;


import com.crealytics.reporting.dao.ReportRepository;
import com.crealytics.reporting.entity.Report;
import com.crealytics.reporting.parser.CSVParser;
import com.crealytics.reporting.services.ReportingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * Populate H2 database with the values.
 */
@Configuration
@MapperScan("com.crealytics.reporting.dao")
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
        janReports.forEach(report -> reportRepository.save(report));

        List<Report> febReports = CSVParser.parse(new ClassPathResource("2018_02_report.csv").getInputStream());
        febReports.forEach(report -> report.setMonth("February"));
        reportingService.generateFullReport(febReports);
        febReports.forEach(report -> reportRepository.save(report));
    }
}
