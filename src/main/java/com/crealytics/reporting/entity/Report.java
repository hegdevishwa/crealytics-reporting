package com.crealytics.reporting.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.CsvBindByPosition;

/**
 * Report Entity
 */
public class Report {

    @CsvBindByPosition(position = 0)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String site;

    @CsvBindByPosition(position = 1)
    private int requests;

    @CsvBindByPosition(position = 2)
    private int impressions;

    @CsvBindByPosition(position = 3)
    private int clicks;

    @CsvBindByPosition(position = 4)
    private int conversions;

    @CsvBindByPosition(position = 5)
    private double revenue;

    private double CTR;
    private double CR;
    private double fill_rate;
    private double eCPM;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String month;


    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests(int requests) {
        this.requests = requests;
    }

    public int getImpressions() {
        return impressions;
    }

    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getConversions() {
        return conversions;
    }

    public void setConversions(int conversions) {
        this.conversions = conversions;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getCTR() {
        return CTR;
    }

    public void setCTR(double CTR) {
        this.CTR = CTR;
    }

    public double getCR() {
        return CR;
    }

    public void setCR(double CR) {
        this.CR = CR;
    }

    public double getFill_rate() {
        return fill_rate;
    }

    public void setFill_rate(double fill_rate) {
        this.fill_rate = fill_rate;
    }

    public double geteCPM() {
        return eCPM;
    }

    public void seteCPM(double eCPM) {
        this.eCPM = eCPM;
    }

    @Override
    public String toString() {
        return "Report{" +
                ", site='" + site + '\'' +
                ", requests=" + requests +
                ", impressions=" + impressions +
                ", clicks=" + clicks +
                ", conversions=" + conversions +
                ", revenue=" + revenue +
                ", CTR=" + CTR +
                ", CR=" + CR +
                ", fill_rate=" + fill_rate +
                ", eCPM=" + eCPM +
                ", month='" + month + '\'' +
                '}';
    }
}
