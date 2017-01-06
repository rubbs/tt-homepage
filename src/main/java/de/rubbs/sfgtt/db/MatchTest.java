package de.rubbs.sfgtt.db;

import au.com.bytecode.opencsv.CSVReader;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by ruben on 06.01.17.
 */
@Slf4j
public class MatchTest extends TestCase {


    public void testParse() throws Exception {

        String csvFile = "/home/ruben/Downloads/Vereinsspielplan_20170106222408.csv";
        BufferedReader br = null;

        br = new BufferedReader(new FileReader(csvFile));
        CSVReader csvReader = new CSVReader(br, ';');

        // read headline
        if (null == csvReader.readNext()) {
            log.error("empty csv file");
            return;
        }

        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null) {

            Match match = new Match(nextLine);
            log.info(match.getSummary());


        }

    }

}