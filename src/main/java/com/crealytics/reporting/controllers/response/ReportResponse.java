package com.crealytics.reporting.controllers.response;

public class ReportResponse extends ResponseWrapper {

    private String site;
    private int requests;
    private int impressions;
    private int clicks;
    private int conversions;
    private double revenue;
    private double CTR;
    private double CR;
    private double fill_rate;
    private double eCPM;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
