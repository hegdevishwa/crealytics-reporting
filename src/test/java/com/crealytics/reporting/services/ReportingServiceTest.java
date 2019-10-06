package com.crealytics.reporting.services;

import com.crealytics.reporting.dao.ReportRepository;
import com.crealytics.reporting.entity.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportingServiceTest {

    @Mock
    ReportRepository reportRepository;

    @InjectMocks
    ReportingService reportingService;


    @Test
    public void test_fndReportForMonthAndSite() {

        when(reportRepository.findByMonthAndSite(any(), any())).thenReturn(new Report());
        assertNotNull(reportingService.findReportForMonthAndSite(any(), any()));
    }

    @Test
    public void test_generateFullReport() {
        Report report = new Report();
        report.setSite("abc");
        report.setRequests(9905942);
        report.setImpressions(9401153);
        report.setClicks(25291);
        report.setConversions(6216);
        report.setRevenue(19053.61);

        List<Report> list = new ArrayList<Report>();
        list.add(report);
        reportingService.generateFullReport(list);
        Report after = list.get(0);
        assertEquals(94.9, after.getFill_rate(), 0);
        assertEquals(0.2, after.geteCPM(), 0);
        assertEquals(0.27, after.getCTR(), 0);
        assertEquals(0.07, after.getCR(), 0);

    }

}
