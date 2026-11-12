package com.sena.hackathon.service;

import com.sena.hackathon.model.AccidentRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvDataService {

    public List<AccidentRecord> loadData() {
        List<AccidentRecord> records = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("data/accidentes_sample.csv");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                boolean isFirstLine = true;
                while ((line = br.readLine()) != null) {
                    if (isFirstLine) { // Saltar cabecera
                        isFirstLine = false;
                        continue;
                    }
                    String[] data = line.split(",");
                    if (data.length >= 4) {
                        records.add(new AccidentRecord(data[0], data[1], data[2], data[3]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }
}