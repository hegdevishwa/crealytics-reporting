package com.crealytics.reporting.parser;

import com.crealytics.reporting.entity.Report;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

/**
 * CSV parser. It uses OpenCSV to parse CSV.
 */
public class CSVParser {

    /**
     *
     * @param file CSV file to parse
     * @return List of reports
     * @throws IOException
     */
    public static List<Report> parse(InputStream file) throws IOException {

        return (List<Report>) new CsvToBeanBuilder(new InputStreamReader(file))
                .withType(Report.class).withSeparator(',').withSkipLines(1).build().parse();

    }

}
