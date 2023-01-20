package br.com.body_measurements.service;

import br.com.body_measurements.dto.MetricDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MetricsCalculator {
    static MetricDTO calculate(CalculatedMetric calculatedMetric, Map<String, Double> metrics) {
        return MetricDTO.builder()
                .name(calculatedMetric.getName())
                .value(calculatedMetric.calculate(metrics))
                .build();
    }

    public static List<MetricDTO> list(Map<String, Double> metrics) {
        List<MetricDTO> dtos = new ArrayList<>();
        dtos.add(calculate(new Imc(), metrics));
        dtos.add(calculate(new FatPerc(), metrics));

        return dtos;
    }
}

interface CalculatedMetric {
    String WEIGHT = "Weight";
    String HEIGHT = "Height";
    String IMC = "Imc";
    String FAT_PERC = "Fat perc";

    String getName();

    double calculate(Map<String, Double> metrics);
}

class Imc implements CalculatedMetric {

    @Override
    public String getName() {
        return IMC;
    }

    @Override
    public double calculate(Map<String, Double> metrics) {
        return metrics.get(WEIGHT) / Math.pow(metrics.get(HEIGHT), 2);
    }
}

class FatPerc implements CalculatedMetric {

    @Override
    public String getName() {
        return FAT_PERC;
    }

    @Override
    public double calculate(Map<String, Double> metrics) {
        return metrics.get(WEIGHT) * (metrics.get(WEIGHT) / Math.pow(metrics.get(HEIGHT), 2) / 100);
    }
}