package com.crealytics.reporting.services;

import com.crealytics.reporting.dao.ReportRepository;
import com.crealytics.reporting.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Service class for generating full report. ALl report related calculations are done here
 */
@Service
public class ReportingService {

    @Autowired
    ReportRepository reportRepository;


    /**
     * Finds report by given month & site
     *
     * @param month
     * @param site
     * @return
     */
    public Report findReportForMonthAndSite(String month, String site) {
        return reportRepository.findByMonthAndSite(month, site);
    }

    /**
     * This method populates all report values
     *
     * @param reports
     */
    public void generateFullReport(List<Report> reports) {
        reports.forEach(report -> {
            report.setCTR(calculateCTR(report));
            report.setCR(calculateCR(report));
            report.setFill_rate(calculateFillRate(report));
            report.seteCPM(calculateECPM(report));
        });
    }

    /**
     * CTR: Click-through rate.  Expressed as a percentage. Literally, the ratio of users who click on a specific
     * link to the number of total users who view an advertisement.
     * CTR = (clicks ÷ impressions) × 100%**
     *
     * @param report
     * @return
     */
    private double calculateCTR(Report report) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(((double) report.getClicks() / report.getImpressions()) * 100));
    }


    /**
     * CR: Conversion rate. The ratio of conversions to the number of impressions
     * CR = (conversions ÷ impressions) × 100%**
     *
     * @param report
     * @return
     */
    private double calculateCR(Report report) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(((double) report.getConversions() / report.getImpressions()) * 100));
    }

    /**
     * Fill Rate: The ratio of impressions to the number of requests. It varies by inventory.
     * Fill Rate = (impressions ÷ requests) × 100%**
     *
     * @param report
     * @return
     */
    private double calculateFillRate(Report report) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(((double) report.getImpressions() / report.getRequests()) * 100));
    }

    /**
     * eCPM: Effective Cost Per Thousand. A translation from CPM, expressed as such from a publisher's point of view.
     * eCPM = (revenue × 1000) ÷ impressions**
     *
     * @param report
     * @return
     */
    private double calculateECPM(Report report) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format((report.getRevenue() * 100) / report.getImpressions()));
    }

}
