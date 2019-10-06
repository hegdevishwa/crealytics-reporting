package com.crealytics.reporting.parser;

import com.crealytics.reporting.domain.Report;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    public static List<Report> parse(File file) throws IOException {

        return (List<Report>) new CsvToBeanBuilder(new FileReader(file))
                .withType(Report.class).withSeparator(',').withSkipLines(1).build().parse();

    }

}
