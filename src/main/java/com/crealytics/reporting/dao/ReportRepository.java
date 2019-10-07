package com.crealytics.reporting.dao;

import com.crealytics.reporting.entity.Report;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Report repository
 */
@Mapper
public interface ReportRepository {

    String SAVE_REPORT = "INSERT INTO REPORT(site , requests , impressions , clicks   ,  conversions, revenue  ,  " +
            "CTR,   CR , fill_rate, eCPM , month) VALUES (#{site}, #{requests},#{impressions}, #{clicks},  " +
            "#{conversions}, #{revenue}, #{CTR}, #{CR}, #{fill_rate},  #{eCPM}, #{month})";

    String FIND_BY_MONTH_AND_SITE = "SELECT * FROM REPORT where month= #{month} and site= #{site}";

    String AGGREGRATED_BY_MONTH = "SELECT SUM (REQUESTS) AS REQUESTS, SUM (IMPRESSIONS) AS IMPRESSIONS, SUM (CLICKS) " +
            "AS " +
            "CLICKS, SUM (CONVERSIONS) AS CONVERSIONS, SUM (REVENUE) AS REVENUE, MONTH FROM REPORT WHERE MONTH = " +
            "#{month}" +
            "GROUP BY MONTH";

    String AGGREGRATED_BY_SITE = "SELECT SUM (REQUESTS) AS REQUESTS, SUM (IMPRESSIONS) AS IMPRESSIONS, SUM (CLICKS) " +
            "AS " +
            "CLICKS, SUM (CONVERSIONS) AS CONVERSIONS, SUM (REVENUE) AS REVENUE, SITE FROM REPORT WHERE SITE = " +
            "#{SITE}" +
            "GROUP BY SITE";

    @Insert(SAVE_REPORT)
    public int save(Report report);

    @Select(FIND_BY_MONTH_AND_SITE)
    Report findByMonthAndSite(String month, String site);

    @Select(AGGREGRATED_BY_MONTH)
    Report aggregatedByMonth(String month);

    @Select(AGGREGRATED_BY_SITE)
    Report aggregatedBySite(String site);
}
