package com.crealytics.reporting.controllers;

import com.crealytics.reporting.controllers.response.ErrorResponse;
import com.crealytics.reporting.controllers.response.ReportResponse;
import com.crealytics.reporting.controllers.response.ResponseWrapper;
import com.crealytics.reporting.entity.Report;
import com.crealytics.reporting.services.ReportingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResponseEntity getReportForGivenMonthAndSite(@PathVariable("month") String month, @PathVariable("site") Site site) {

        Report report = reportingService.findReportForMonthAndSite(getMonth(month), site.getValue());
        ResponseEntity response;
        if (report == null) {
            response = buildErrorResponse("Report not found.", HttpStatus.NOT_FOUND);
        } else {
            response = buildResponse(report);
        }
        return response;
    }


    private ResponseEntity<ResponseWrapper> buildResponse(Report report) {
        ReportResponse reportResponse = new ReportResponse();
        BeanUtils.copyProperties(report, reportResponse);
        return new ResponseEntity(reportResponse, HttpStatus.OK);
    }

    private ResponseEntity<ResponseWrapper> buildErrorResponse(String message, HttpStatus status) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorMessage(message);
        return new ResponseEntity(error, status);
    }

    private static String getMonth(String month) {

        Map<String, String> mapOfNumberToMonth = new HashMap<>();
        mapOfNumberToMonth.put("1", "January");
        mapOfNumberToMonth.put("2", "February");

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
