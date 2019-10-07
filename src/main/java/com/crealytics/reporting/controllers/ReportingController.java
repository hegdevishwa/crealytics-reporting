package com.crealytics.reporting.controllers;

import com.crealytics.reporting.entity.Report;
import com.crealytics.reporting.entity.Site;
import com.crealytics.reporting.services.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/reports")
public class ReportingController {

    @Autowired
    ReportingService reportingService;

    /**
     * Reporting based on month and site combination
     *
     * @param month month for for which report to be generated
     * @param site  site for which report to be generated
     * @return report for the given month & site combination
     */
    @RequestMapping("{month}/{site}")
    @ResponseBody
    public ResponseEntity getReportForGivenMonthAndSite(@PathVariable("month") String month,
                                                        @PathVariable("site") Site site) {

        Report report = reportingService.findReportForMonthAndSite(getMonth(month), site.getValue());
        ResponseEntity response;
        if (report == null) {
            response = new ResponseEntity("Report not found.", HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(report, HttpStatus.OK);
        }
        return response;
    }

    /**
     * Report aggregated by a given month
     *
     * @param month
     * @return
     */
    @RequestMapping(params = {"month"})
    @ResponseBody
    public ResponseEntity getReportForMonth(@RequestParam String month) {

        Report report = reportingService.aggregatedByMonth(getMonth(month));
        ResponseEntity response;
        if (report == null) {
            response = new ResponseEntity("Report not found.", HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(report, HttpStatus.OK);
        }
        return response;
    }

    /**
     * Report aggregated by a given site
     *
     * @param site
     * @return
     */
    @RequestMapping(params = {"site"})
    @ResponseBody
    public ResponseEntity getReportForSite(@RequestParam Site site) {

        Report report = reportingService.aggregatedBySite(site.getValue());
        ResponseEntity response;
        if (report == null) {
            response = new ResponseEntity("Report not found.", HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(report, HttpStatus.OK);
        }
        return response;
    }


    private static String getMonth(String month) {

        Map<String, String> mapOfNumberToMonth = new HashMap<>();
        mapOfNumberToMonth.put("1", "January");
        mapOfNumberToMonth.put("2", "February");
        mapOfNumberToMonth.put("3", "March");
        mapOfNumberToMonth.put("4", "April");
        mapOfNumberToMonth.put("5", "May");
        mapOfNumberToMonth.put("6", "June");
        mapOfNumberToMonth.put("7", "July");
        mapOfNumberToMonth.put("8", "August");
        mapOfNumberToMonth.put("9", "September");
        mapOfNumberToMonth.put("10", "October");
        mapOfNumberToMonth.put("11", "November");
        mapOfNumberToMonth.put("12", "December");


        Map<String, String> mapOfShortMonthToMonth = new HashMap<>();
        mapOfShortMonthToMonth.put("jan", "January");
        mapOfShortMonthToMonth.put("feb", "February");

        String mappedMonth;

        if (month.length() <= 3) {
            mappedMonth = mapOfNumberToMonth.get(month);
            if (mappedMonth == null || mappedMonth.isEmpty()) {
                mappedMonth = mapOfShortMonthToMonth.get(month);
            }
        } else {
            mappedMonth = month;
        }
        return mappedMonth;

    }
}
