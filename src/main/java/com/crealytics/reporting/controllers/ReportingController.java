package com.crealytics.reporting.controllers;

import com.crealytics.reporting.domain.Report;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/v1/reports")
public class ReportingController {

    /**
     * Reporting based on month and site combination
     *
     * @param month month for for which report to be generated
     * @param site site for which report to be generated
     * @return report for the given month & site combination
     */
    @RequestMapping
    @ResponseBody
    public Report reportGenerator(@PathParam("month") String month, @PathParam("site") String site) {
        Report report = new Report();
        report.setSite("desktop web");
        report.setRequests(12483775);
        report.setImpressions(11866157);
        report.setClicks(30965);
        report.setConversions(7608);
        report.setRevenue(23555.46);
        return report;
    }
}
