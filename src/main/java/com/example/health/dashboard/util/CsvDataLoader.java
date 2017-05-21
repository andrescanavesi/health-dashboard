package com.example.health.dashboard.util;

import com.example.health.dashboard.entities.Analysis;
import com.example.health.dashboard.entities.AnalysisType;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * The CSV content must have the following columns:
 *
 * Analysis, Group, Result, Date, Min, Max, Units
 *
 * @author Andres Canavesi
 */
public class CsvDataLoader {

    private static final Logger LOG = Logger.getLogger(CsvDataLoader.class.getName());

    /**
     *
     */
    public CsvDataLoader() {
    }

    /**
     *
     * @param reader
     * @param skipFirstLine
     * @return
     * @throws Exception
     */
    private Map<AnalysisType, List<Analysis>> read(CSVReader reader, boolean skipFirstLine) throws Exception {
        if (skipFirstLine) {
            reader.readNext();
        }
        Map<AnalysisType, List<Analysis>> analysisMap = new HashMap<>();
        String[] line;
        while ((line = reader.readNext()) != null) {
            String analysisName = line[0];
            String group = line[1];
            String result = line[2];
            String date = line[3];
            String min = line[4];
            String max = line[5];
            String units = line[6];

            AnalysisType analysisType = new AnalysisType();
            analysisType.setGroup(group);
            analysisType.setMax(new Double(max));
            analysisType.setMin(new Double(min));
            analysisType.setName(analysisName);
            analysisType.setUnits(units);

            if (!analysisMap.containsKey(analysisType)) {
                analysisMap.put(analysisType, new ArrayList<Analysis>());
            }
            Analysis analysis = new Analysis();
            analysis.setAnalysisType(analysisType);
            analysis.setResult(new Double(result));
            analysis.setDateByString(date);
            analysisMap.get(analysisType).add(analysis);
        }

        return analysisMap;
    }

    /**
     *
     * @param content
     * @param skipFirstLine
     * @return
     * @throws Exception
     */
    public Map<AnalysisType, List<Analysis>> loadFromString(String content, boolean skipFirstLine) throws Exception {
        LOG.info("Loading csv stirng...");
        CSVReader reader = new CSVReader(new StringReader(content));
        return read(reader, skipFirstLine);
    }

    /**
     *
     * @param csvPath
     * @param skipFirstLine
     * @return
     * @throws Exception
     */
    public Map<AnalysisType, List<Analysis>> loadFromFile(String csvPath, boolean skipFirstLine) throws Exception {
        LOG.info("Loading csv file...");
        CSVReader reader = new CSVReader(new FileReader(csvPath));
        return read(reader, skipFirstLine);

    }

}
