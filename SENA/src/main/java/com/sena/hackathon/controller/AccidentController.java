package com.sena.hackathon.controller;

import com.sena.hackathon.model.AccidentRecord;
import com.sena.hackathon.service.CsvDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AccidentController {

    @Autowired
    private CsvDataService csvDataService;

    @GetMapping("/")
    public String index(@RequestParam(name = "filtro", required = false) String filtro, Model model) {
        List<AccidentRecord> records = csvDataService.loadData();

        if (filtro != null && !filtro.isEmpty()) {
            records = records.stream()
                    .filter(r -> r.getLocalidad().toLowerCase().contains(filtro.toLowerCase()) ||
                                 r.getTipoVehiculo().toLowerCase().contains(filtro.toLowerCase()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("records", records);
        model.addAttribute("filtro", filtro);
        return "index";
    }
}