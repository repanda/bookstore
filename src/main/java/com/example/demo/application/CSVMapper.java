package com.example.demo.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class CSVMapper {

    private static final String COMMA_DELIMITER = ",";

    static List<List<String>> mapCsvFile(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean skipHeader = true;
            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] values = line.split(COMMA_DELIMITER);
                if (values.length > 1) {
                    List<String> result = Arrays.stream(values).map(value -> value.replace("\"", "")).collect(Collectors.toList());
                    records.add(result);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while mapCsvFile");
        }
        return records;
    }
}
